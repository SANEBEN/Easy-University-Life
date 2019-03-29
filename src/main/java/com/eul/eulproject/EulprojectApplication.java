package com.eul.eulproject;

import com.eul.eulproject.controller.chat.netty.WebSocketServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;

@SpringBootApplication
@MapperScan("com.eul.eulproject.mapper")
public class EulprojectApplication implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

    public static void main(String[] args) {
        SpringApplication.run(EulprojectApplication.class);
        try {
            new WebSocketServer().run(9999);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        new websocketServer(9999).start();
    }

    @Override
    public void customize(ConfigurableServletWebServerFactory factory) {
        factory.setPort(8088);
    }
}
