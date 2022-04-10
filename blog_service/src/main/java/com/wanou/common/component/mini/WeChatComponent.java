package com.wanou.common.component.mini;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wanou.common.exception.OpenIdException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * 微信通用组件
 */
@Component
public class WeChatComponent {

    @Value("${weChat.appId}")
    private String appId;
    @Value("${weChat.appSecret}")
    private String appSecret;

    private static final String weChatUrl = "https://api.weixin.qq.com/sns/jscode2session" +
            "?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private ObjectMapper objectMapper;

    /**
     * 根据code码获取用户的OpenId
     * @param code code码
     * @return openId
     */
    public String getOpenIdByCode(String code){
        String authUrl  = String.format(weChatUrl,appId,appSecret,code);
        String result = restTemplate.getForObject(authUrl, String.class);
        try {
            JsonNode jsonNode = objectMapper.readTree(result);
            if (jsonNode.get("errcode")==null){
                return jsonNode.get("openid").asText();
            }else {
                throw new OpenIdException();
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new OpenIdException();
        }

    }


}
