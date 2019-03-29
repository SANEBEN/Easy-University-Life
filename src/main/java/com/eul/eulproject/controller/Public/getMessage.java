package com.eul.eulproject.controller.Public;

import com.eul.eulproject.entity.information.message;
import com.eul.eulproject.service.messageService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用于获取用户的个人资料
 */

@RestController
public class getMessage {

    private messageService messageService;

    @Autowired
    getMessage(messageService messageService){
        this.messageService = messageService;
    }

    @PostMapping("/getUserMessage")
    public message getUserMessage(@Param(value = "Uid") String Uid){
        return messageService.getMessage(Uid);
    }
}
