package com.lyf.springbootall.websocket;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@Component
@ServerEndpoint("/websocket/{sid}")
public class DemoWebsocketServer {

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("sid") String sid) {
        System.out.println("连接成功");
    }

    @OnClose
    public void onClose() {
        System.out.println("连接关闭");
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.printf("收到客户端消息：%s", message);
        sendMessage(session, message);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.printf("服务端异常：%s", error.getMessage());
        error.printStackTrace();
    }

    /**
     * 实现服务器主动推送
     */
    private void sendMessage(Session session, String message) throws IOException {
        session.getBasicRemote().sendText(message);
    }

}
