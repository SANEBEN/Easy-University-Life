package com.eul.eulproject.service.Imp;

import com.eul.eulproject.entity.information.message;
import com.eul.eulproject.entity.information.messageSimple;
import com.eul.eulproject.mapper.messageMapper;
import com.eul.eulproject.service.messageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class messageServiceImp implements messageService {

    private messageMapper messageMapper;

    @Autowired
    messageServiceImp(messageMapper messageMapper){
        this.messageMapper = messageMapper;
    }

    @Override
    public message getMessage(String Uid){
        return messageMapper.getByUid(Uid);
    }

    @Override
    public messageSimple getSimpleMessage(String Uid) {
        return messageMapper.getSimpleMessage(Uid);
    }
}
