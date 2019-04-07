package com.eul.eulproject.controller.chat.netty.service;

import com.eul.eulproject.service.subscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 推送的实现
 */

@RestController
public class subscribe {

    /**
     * 储存推送关系的数据库
     */
    private subscribeService subscribeService;

    @Autowired
    subscribe(subscribeService subscribeService) {
        this.subscribeService = subscribeService;
    }

    /**
     * 实现添加订阅功能
     * @param author 发送推送的作者
     * @param customer 接受推送的读者
     * @return 返回是否订阅成功的结果
     */
    @PostMapping("/subscribe/add")
    public String add(int author, int customer) {
        return subscribeService.add(author, customer) ? "订阅成功" : "订阅失败，请稍后重试";
    }

    @PostMapping("/subscribe/send")
    public String send(int author ,int data){
        List<String> customer = subscribeService.get(author);

        return "";
    }
}
