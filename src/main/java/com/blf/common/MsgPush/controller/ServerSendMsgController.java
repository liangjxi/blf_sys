package com.blf.common.MsgPush.controller;

import com.blf.common.MsgPush.handler.SystemWebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.TextMessage;

import javax.servlet.http.HttpServletRequest;

/**
 * User: Tennyson
 * E-Mail:wangxing@bailefen.com
 * Project:blf_sys
 * Package:com.blf.common.MsgPush.controller
 * DateTime: 2017/7/7  15:56
 * Description:手动添加
 */
@Controller
@RequestMapping("")
public class ServerSendMsgController {

    @Bean
    public SystemWebSocketHandler systemWebSocketHandler(){
        return new SystemWebSocketHandler();
    }

    public String sendMsg(HttpServletRequest request){
        systemWebSocketHandler().sendMsg2Users(new TextMessage("message"));
        return null;
    }
}
