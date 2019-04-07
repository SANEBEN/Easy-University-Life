package com.eul.eulproject.controller.chat.netty;

import com.eul.eulproject.entity.chat.Record;
import com.eul.eulproject.service.chatRecordService;
import com.eul.eulproject.tool.springUtil;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NettyServerHandler extends SimpleChannelInboundHandler<String> {

    private Logger logger = LoggerFactory.getLogger(NettyServerHandler.class);
    private int id;
    private static Map<Integer, ChannelHandlerContext> onlineUser = new ConcurrentHashMap<>();
    private chatRecordService chatRecordService = springUtil.getBean(chatRecordService.class);
    private final String END = "\r\n";

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String str) {
        logger.info("收到websocket信息" + str);
        JsonObject json = new JsonParser().parse(str).getAsJsonObject();
        switch (json.get("head").getAsInt()) {
            case 1:
                id = json.get("body").getAsInt();
                onlineUser.put(id, ctx);
                logger.info("成功初始化连接对象ID：" + id);
                break;
            case 2:
                JsonObject data = new JsonParser().parse(json.get("body").getAsString().replaceAll("\\\\", "")).getAsJsonObject();
                send(ctx, data);
                break;
            default:
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        logger.info("连接已经建立");
        ctx.channel().writeAndFlush("连接成功" + END);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        logger.info("连接已经被销毁");
        onlineUser.remove(id);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.info("============websocket服务出错=============");
        logger.info(cause.getMessage());
        super.exceptionCaught(ctx, cause);
    }

    /**
     * 给指定目标发送消息
     * @param context 存储有发送人消息通道
     * @param data 发送的消息的本体
     */
    private void send(ChannelHandlerContext context, JsonObject data) {
        if (onlineUser.containsKey(data.get("to").getAsInt())) {
            JsonObject a = new JsonObject();
            a.addProperty("type", 4);
            a.addProperty("body", data.get("content").getAsString());
            onlineUser.get(data.get("to").getAsInt())
                    .channel()
                    .writeAndFlush(a.toString() + END)
                    .addListener((ChannelFuture future) -> {
                        if (future.isSuccess()) {
                            logger.info("消息发送成功");
                        } else {
                            logger.info("消息发送失败");
                        }
                    });
        }else {
            logger.info("目标对象不在线");
        }
        addRecord(data);
    }

    /**
     * 将消息存储到数据库里
     * @param data 消息实体
     */
    private void addRecord(JsonObject data) {
        Record record = new Record();
        try {
            record.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse(data.get("time").getAsString()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        record.setFROM_id(data.get("from").getAsInt());
        record.setTO_id(data.get("to").getAsInt());
        record.setContent(data.get("content").getAsString());
        chatRecordService.insert(record);
    }

    /**
     * 实现推送
     *
     * @param context 接受推送的具体用户的集合
     * @param data    推送的具体内容，为一个JsonObject类的对象
     */
    public void subscribe(ChannelHandlerContext context, JsonObject data) {
        Channel channel = context.channel();
        ChannelFuture result = channel.writeAndFlush(data + END);
        logger.info(result.toString());
    }

    /**
     * 获取当前在线用户的集合
     * @return 返回包含所有用户信息的集合
     */
    public static Map<Integer, ChannelHandlerContext> getOnlineUser() {
        return onlineUser;
    }
}
