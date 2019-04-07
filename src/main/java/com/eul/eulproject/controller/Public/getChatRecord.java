package com.eul.eulproject.controller.Public;

import com.eul.eulproject.entity.chat.Record;
import com.eul.eulproject.service.chatRecordService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用于获取用户的聊天记录
 */

@RestController
public class getChatRecord {
    private chatRecordService chatRecordService;

    @Autowired
    getChatRecord(chatRecordService chatRecordService){
        this.chatRecordService = chatRecordService;
    }

    @PostMapping("/getRecord")
    public List<Record> getRecordByUid(
            @Param(value = "fId") String fId,
            @Param(value = "mId") String mId){
        return chatRecordService.getRecord(fId,mId);
    }
}
