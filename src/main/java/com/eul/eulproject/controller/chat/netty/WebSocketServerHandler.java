package com.eul.eulproject.controller.chat.netty;

import com.eul.eulproject.controller.chat.netty.message.General;
import com.eul.eulproject.controller.chat.netty.message.chatMessage;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class WebSocketServerHandler extends SimpleChannelInboundHandler<String> {

    private Logger logger = LoggerFactory.getLogger(WebSocketServerHandler.class);
    private String id;
    private Map<String, WebSocketServerHandler> onlineUser = new HashMap<>();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String str) {
        logger.info("收到websocket信息" + str);
        General general = new Gson().fromJson(str, General.class);
        switch (general.getType()) {
            case 1:
                chatMessage message = (chatMessage) general.getMessage();
                logger.info("收到发送的信息：" + message.getContent());
                break;
            case 2:
                break;
            default:
                break;
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        logger.info("连接已经建立");
        ctx.channel().writeAndFlush("连接成功");
        id = ctx.channel().id().asShortText();
        onlineUser.put(id, this);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        logger.info("连接已经被销毁");
        onlineUser.remove(id);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.info("websocket服务出错");
        logger.info(cause.getMessage());
        super.exceptionCaught(ctx, cause);
    }
}
