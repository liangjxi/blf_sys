package com.blf.common.MsgPush.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * User: Tennyson
 * E-Mail:wangxing@bailefen.com
 * Project:blf_sys
 * Package:com.blf.common.MsgPush.handler
 * DateTime: 2017/7/7  15:07
 * Description:手动添加
 */

@Component
public class InfoSocketEndPoint extends TextWebSocketHandler {


    public InfoSocketEndPoint(){

    }

    @Override
    protected void handleTextMessage(WebSocketSession session,TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
        TextMessage returnMessage = new TextMessage(message.getPayload()
                + " received at server");
        session.sendMessage(returnMessage);
    }
}
