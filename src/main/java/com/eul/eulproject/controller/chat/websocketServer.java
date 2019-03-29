package com.eul.eulproject.controller.chat;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class websocketServer extends WebSocketServer {

    private String id;
    private static Map<String, websocketServer> onlineUser = new ConcurrentHashMap<>();
    private Logger logger = LoggerFactory.getLogger(websocketServer.class);

    public websocketServer(int port) {
        super(new InetSocketAddress(port));
    }
    public websocketServer(InetSocketAddress address) {
        super(address);
    }

    @Override
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
        id = webSocket.getResourceDescriptor().replaceAll("/", "");
        if(id.equals("")){
            webSocket.send("请以正确的方式连接");
        }
        logger.info("连接的主机IP为:" + webSocket.getRemoteSocketAddress().getAddress().getHostAddress());
        logger.info(id + "创建了新的连接");
        websocketServer.onlineUser.put(id, this);
        broadcast(id + "建立了连接");
    }

    @Override
    public void onClose(WebSocket webSocket, int i, String s, boolean b) {
        websocketServer.onlineUser.remove(id);
        logger.info(id + "断开了连接");
    }

    @Override
    public void onMessage(WebSocket webSocket, String s) {
        logger.info("收到来自" + id + "的消息："+s);
    }

    @Override
    public void onError(WebSocket webSocket, Exception e) {
        websocketServer.onlineUser.remove(id);
        logger.info(e.getMessage());
    }

    @Override
    public void onStart() {
        logger.info("websocket服务启动");
    }
}
