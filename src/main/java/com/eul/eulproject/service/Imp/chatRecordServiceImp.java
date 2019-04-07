package com.eul.eulproject.service.Imp;

import com.eul.eulproject.entity.chat.Record;
import com.eul.eulproject.mapper.chatRecordMapper;
import com.eul.eulproject.service.chatRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
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
    public List<Record> getRecord(String friendId, String myId) {
        List<Record> records = new ArrayList<>();
        records.addAll(chatRecordMapper.getRecord_from(friendId,myId));
        records.addAll(chatRecordMapper.getRecord_to(friendId, myId));
        records.sort(new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {
                return o1.getTime_AsDate().compareTo(o2.getTime_AsDate());
            }
        });
        return records;
    }

    @Override
    public boolean insert(Record record) {
        return chatRecordMapper.insert(record);
    }
}
