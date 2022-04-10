package com.wanou.common.component.webSocket;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.log.LogFactory;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wanou.common.constant.Constants;
import com.wanou.framework.redis.RedisCache;
import com.wanou.project.system.domain.SysDept;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author txh
 * @date 2021/8/14 16:11
 * webSocket服务组件
 */
@ServerEndpoint("/wsServer/{userId}")
@Component
@Slf4j
public class WebSocketServer {
    /**静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。*/
    private static int onlineCount = 0;
    /**concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。*/
    private static ConcurrentHashMap<String,WebSocketServer> webSocketMap = new ConcurrentHashMap<>();
    /**与某个客户端的连接会话，需要通过它来给客户端发送数据*/
    private Session session;
    /**接收userId*/
    private String userId="";

    @Autowired
    private RedisCache redisCache;

    /**
     * 连接建立成功调用的方法*/
    @OnOpen
    public void onOpen(Session session,@PathParam("userId") String userId) {
        this.session = session;
        this.userId=userId;
        if(webSocketMap.containsKey(userId)){
            webSocketMap.remove(userId);
            webSocketMap.put(userId,this);
            //加入set中
        }else{
            webSocketMap.put(userId,this);
            //加入set中
            addOnlineCount();
            //在线数加1
        }

        log.info("用户连接:"+userId+",当前在线人数为:" + getOnlineCount());

        try {
            sendMessage("连接成功");
        } catch (IOException e) {
            log.error("用户:"+userId+",网络异常!!!!!!");
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        if(webSocketMap.containsKey(userId)){
            webSocketMap.remove(userId);
            //从set中删除
            subOnlineCount();
        }
        log.info("用户退出:"+userId+",当前在线人数为:" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息*/
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("用户消息:"+userId+",报文:"+message);
        //可以群发消息
        //消息保存到数据库、redis
        if(StrUtil.isNotBlank(message)){
            try {
                //解析发送的报文
                JSONObject jsonObject = JSON.parseObject(message);
                //追加发送人(防止串改)
                jsonObject.put("fromUserId",this.userId);
                String toUserId=jsonObject.getString("toUserId");
                //传送给对应toUserId用户的websocket
                if(StrUtil.isNotBlank(toUserId)&&webSocketMap.containsKey(toUserId)){
                    webSocketMap.get(toUserId).sendMessage(jsonObject.toJSONString());
                }else{
                    log.error("请求的userId:"+toUserId+"不在该服务器上");
                    //否则不在这个服务器上，发送到mysql或者redis
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("用户错误:"+this.userId+",原因:"+error.getMessage());
        error.printStackTrace();
    }
    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    /**
     * 实现服务器主动推送对象
     */
    public void sendObject(Object obj) throws IOException {
        this.session.getBasicRemote().sendText(JSON.toJSONString(obj));
        /*try {
            this.session.getBasicRemote().sendObject(obj);
        } catch (EncodeException e) {
            e.printStackTrace();
        }*/
    }

    /**
     * 发送自定义消息
     * */
    public static void sendInfo(String message,@PathParam("userId") String userId) throws IOException {
        log.info("发送消息到:"+userId+"，报文:"+message);
        if(StrUtil.isNotBlank(userId)&&webSocketMap.containsKey(userId)){
            webSocketMap.get(userId).sendMessage(message);
        }else{
            log.error("用户"+userId+",不在线！");
        }
    }

    /**
     * 群发自定义对象
     * */
    public static void sendObjectInfo(Object object,String deptId) throws IOException {
        if(StrUtil.isNotBlank(deptId)){
            ConcurrentHashMap.KeySetView<String, WebSocketServer> keys = webSocketMap.keySet();
            for (String key : keys) {
                if(key.startsWith(deptId + "_")){
                    webSocketMap.get(key).sendObject(object);
                }
            }
        }
    }

    /**
     * 群发所有人
     * */
    public static void sendInfoAllUser(String message) throws IOException {
        ConcurrentHashMap.KeySetView<String, WebSocketServer> keys = webSocketMap.keySet();
        for (String key : keys) {
            webSocketMap.get(key).sendMessage(message);
        }
    }

    /**
     * 群发所有人
     * */
    public static void sendInfoObjAllUser(Object object) throws IOException {
        ConcurrentHashMap.KeySetView<String, WebSocketServer> keys = webSocketMap.keySet();
        for (String key : keys) {
            webSocketMap.get(key).sendObject(object);
        }
    }

    /**
     * 根据部门id列表发送对象信息
     * @param object
     * @param deptIds
     * @throws IOException
     */
    public static void sendInfoObjByDeptIds(Object object,List<String> deptIds) throws IOException {
        ConcurrentHashMap.KeySetView<String, WebSocketServer> keys = webSocketMap.keySet();
        if (keys.isEmpty()){
            return;
        }
        for (String deptId : deptIds) {
            for (String key : keys) {
                if(key.startsWith(deptId + "_")){
                    webSocketMap.get(key).sendObject(object);
                    break;
                }
            }
        }
    }

    /**
     * 根据部门id列表发送字符串消息
     * @param message
     * @param deptIds
     * @throws IOException
     */
    public static void sendInfoByDeptIds(String message,List<String> deptIds) throws IOException {
        ConcurrentHashMap.KeySetView<String, WebSocketServer> keys = webSocketMap.keySet();
        if (keys.isEmpty()){
            return;
        }
        for (String deptId : deptIds) {
            for (String key : keys) {
                if(key.startsWith(deptId + "_")){
                    webSocketMap.get(key).sendMessage(message);
                    break;
                }
            }
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }
}
