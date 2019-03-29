package com.eul.eulproject.controller.Public;

import com.eul.eulproject.entity.course.courseSimple;
import com.eul.eulproject.entity.form.simpleData;
import com.eul.eulproject.service.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于登录管理
 */

@RestController
public class login {
    private Logger logger = LoggerFactory.getLogger(login.class);
    private messageService messageService;
    private loginService loginService;
    private friendService friendService;
    private scheduleService scheduleService;
    private courseService courseService;

    @Autowired
    login(messageService messageService,
          loginService loginService,
          friendService friendService,
          scheduleService scheduleService,
          courseService courseService) {
        this.loginService = loginService;
        this.messageService = messageService;
        this.friendService = friendService;
        this.scheduleService = scheduleService;
        this.courseService = courseService;
    }

    @RequestMapping("/updatePassword")
    public String updatePassword() {
        List<com.eul.eulproject.entity.information.login> logins = loginService.getAll();
        for (com.eul.eulproject.entity.information.login login : logins) {
            String password = login.getPassword();
            String ID = login.getID();
            ByteSource credentialsSalt = ByteSource.Util.bytes(ID);
            String newPassword = new SimpleHash("MD5", password
                    , credentialsSalt, 1024).toHex();
            loginService.update(ID, newPassword);
        }
        return "密码更新成功";
    }

    @PostMapping("/login")
    public String userLogin(@Param(value = "userName") String userName,
                            @Param(value = "password") String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password, false);
        JsonObject json = new JsonObject();
        try {
            subject.login(token);
            json.addProperty("status", 1);
            com.eul.eulproject.entity.information.login login = (com.eul.eulproject.entity.information.login) subject.getPrincipal();
            simpleData data = new simpleData();
            data.setMessageSimple(messageService.getSimpleMessage(login.getID()));
            data.setFriendSimpleList(friendService.getSimpleFriends(login.getID()));
            List<String> allCid = scheduleService.getCourseList(login.getID());
            List<courseSimple> courses = new ArrayList<>();
            for(String Cid : allCid){
                courses.add(courseService.getSimpleByID(Cid));
            }
            data.setCourseSimpleList(courses);
            json.add("body", new JsonParser().parse(new Gson().toJson(data)));
            return json.toString();
        } catch (IncorrectCredentialsException e) {
            json.addProperty("status", 0);
            json.addProperty("body", "登录密码错误");
            return json.toString();
        } catch (AuthenticationException e) {
            json.addProperty("status", 0);
            json.addProperty("body", "用户不存在");
            return json.toString();
        }
    }
}
