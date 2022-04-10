package com.wanou.framework.security.mini;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * miniApp的上下文环境
 */
public class MiniContextUtils implements Serializable {

    private static final long serialVersionUID = -581073604167398111L;
    private static ThreadLocal<String> miniUserInfo = new ThreadLocal<>();

    private static final ObjectMapper objectMapper = new ObjectMapper();


    protected static void setUserInfo(String userInfo) {
        miniUserInfo.set(userInfo);
    }

    /**
     * getOpenId 和 getPhoneNum只能使用其中一个,并且一个请求只能使用一次
     *
     * @return 获取业主小程序openId
     */
    public static String getOpenId() {
        String userInfo = miniUserInfo.get();
        try {
            return objectMapper.readTree(userInfo).get("openId").asText();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            remove();
        }
    }

    /**
     *
     * @return 获取小程序用户userId
     */
    public static Long getUserId() {
        String userInfo = miniUserInfo.get();
        try {
            return objectMapper.readTree(userInfo).get("id").asLong();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            remove();
        }
    }

    /**
     * 获取当前用户的miniToken
     * @return
     */
    public static String getMiniToken(){
        String userInfo = miniUserInfo.get();
        try {
            return objectMapper.readTree(userInfo).get("miniToken").asText();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            remove();
        }
    }

    /**
     * 获取用户id和token
     * @return
     */
    public static Map<String,String> getUserIdAndMiniToken(){
        String userInfo = miniUserInfo.get();
        try {
            Map<String,String> result = new ConcurrentHashMap<>();
            String miniToken = objectMapper.readTree(userInfo).get("miniToken").asText();
            String userId = objectMapper.readTree(userInfo).get("id").asText();
            result.put("miniToken",miniToken);
            result.put("userId",userId);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            remove();
        }
    }

    //移除线程绑定信息
    public static void remove() {
        miniUserInfo.remove();
    }
}
