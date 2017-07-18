package com.blf.common.MsgPush.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

import java.io.IOException;

/**
 * User: Tennyson
 * E-Mail:wangxing@bailefen.com
 * Project:blf_sys
 * Package:com.blf.common.MsgPush.handler
 * DateTime: 2017/7/7  15:03
 * Description:手动添加
 */
@Component
public class SystemWebSocketHandler implements WebSocketHandler {

    //与客户端完成连接
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("connect to the websocket success......");
        session.sendMessage(new TextMessage("Server:connected OK!"));
    }

    //接收消息
    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        TextMessage returnMessage = new TextMessage(webSocketMessage.getPayload() + " received at server");
        webSocketSession.sendMessage(returnMessage);
    }

    //消息传输出错
    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        if(webSocketSession.isOpen()){
            webSocketSession.close();
        }
        System.out.println("websocket connection closed......");
    }

    //断开
    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        System.out.println("websocket connection closed......");
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    /**
     * 给指定用户推送消息
     * @param userName
     * @param msg
     */
    public void sendMsg2User(String userName,TextMessage msg){
//        for (WebSocketSession user : users) {
//            if (user.getAttributes().get(Constants.WEBSOCKET_USERNAME).equals(userName)) {
//                try {
//                    if (user.isOpen()) {
//                        user.sendMessage(message);
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                break;
//            }
//        }
    }

    /**
     * 给所有用户推送消息
     * @param msg
     */
    public void sendMsg2Users(TextMessage msg){
//        for (WebSocketSession user : users) {
//            try {
//                if (user.isOpen()) {
//                    user.sendMessage(message);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
