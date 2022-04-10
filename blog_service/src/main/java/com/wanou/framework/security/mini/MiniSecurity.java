package com.wanou.framework.security.mini;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wanou.common.component.mini.AesSecretComponent;
import com.wanou.common.constant.Constants;
import com.wanou.common.exception.MiniUserLoginException;
import com.wanou.framework.redis.RedisCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Component
public class MiniSecurity {

    private final static Logger log = LoggerFactory.getLogger(MiniSecurity.class);
    @Resource
    private AesSecretComponent aesSecretComponent;
    @Autowired
    private RedisCache redisCache;

    public boolean check(Authentication authentication, HttpServletRequest request) {
        String miniToken = request.getHeader("miniToken");
        if (StringUtils.isEmpty(miniToken)) {
            return false;
        }
        Object cache = redisCache.getObjectBound(Constants.MINI_USER_LOGIN + miniToken);
        if(cache == null){
            //登录过期
            return false;
        }
        Long boundObjectExpireTime = redisCache.getBoundObjectExpireTime(Constants.MINI_USER_LOGIN + miniToken);
        if(boundObjectExpireTime == null){
            return false;
        }
        if(boundObjectExpireTime < 60*30){
            //缓存时间不足30分钟,刷新缓存
            redisCache.setObjectBoundExpire(Constants.MINI_USER_LOGIN + miniToken,cache,60*60*24*3); //三天过期
        }
        try {
            String userinfo = aesSecretComponent.decrypt(miniToken);
            JSONObject jsonObject = JSON.parseObject(userinfo);
            jsonObject.put("miniToken",miniToken);
            log.debug("小程序请求头鉴权:[{}]", JSON.toJSONString(jsonObject));
            MiniContextUtils.setUserInfo(JSON.toJSONString(jsonObject));
            return true;
        } catch (Exception e) {
            log.error("解密异常,token被篡改", e.getMessage());
            return false;
        }

    }
}
