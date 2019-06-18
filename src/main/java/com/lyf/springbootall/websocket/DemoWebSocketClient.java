package com.lyf.springbootall.websocket;


import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

/**
 * TODO : 这个客户端貌似用不了
 */
public class DemoWebSocketClient extends WebSocketClient {


    public DemoWebSocketClient(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        System.out.println("客户端连接成功");
    }

    @Override
    public void onMessage(String s) {
        System.out.printf("客户端收到消息：%s", s);
    }

    @Override
    public void onClose(int i, String s, boolean b) {
        System.out.println("客户端关闭");
    }

    @Override
    public void onError(Exception e) {
        System.out.printf("客户端出现异常：%s", e.getMessage());
    }
}
