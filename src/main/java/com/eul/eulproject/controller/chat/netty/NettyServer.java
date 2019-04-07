package com.eul.eulproject.controller.chat.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NettyServer {

    private Logger logger = LoggerFactory.getLogger(NettyServer.class);

    public void run(int Port) throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new NettyServerInitializer())
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            logger.info("--启动websocket服务--");
            ChannelFuture f = b.bind(Port).sync();
            f.channel().closeFuture().sync();
        } finally {
            logger.info("--关闭websocket服务--");
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

}
