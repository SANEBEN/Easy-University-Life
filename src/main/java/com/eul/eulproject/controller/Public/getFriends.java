package com.eul.eulproject.controller.Public;

import com.eul.eulproject.entity.friends.friend;
import com.eul.eulproject.service.friendService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用于获取好友
 */

@RestController
public class getFriends {

    private friendService friendService;

    @Autowired
    getFriends(friendService friendService){
        this.friendService = friendService;
    }

    @PostMapping("/getFriendsByUid")
    public List<friend> getByUid(@Param(value = "Uid") String Uid){
        return friendService.getByUid_complete(Uid);
    }
}
