package com.eul.eulproject.service.Imp;

import com.eul.eulproject.entity.chat.Record;
import com.eul.eulproject.mapper.chatRecordMapper;
import com.eul.eulproject.service.chatRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class chatRecordServiceImp implements chatRecordService {

    private chatRecordMapper chatRecordMapper;

    @Autowired
    chatRecordServiceImp(chatRecordMapper chatRecordMapper){
        this.chatRecordMapper = chatRecordMapper;
    }

    @Override
    public List<Record> getByUid(String Uid) {
        return chatRecordMapper.getByUid(Uid);
    }

    @Override
    public boolean insert(Record record) {
        return chatRecordMapper.insert(record);
    }
}
