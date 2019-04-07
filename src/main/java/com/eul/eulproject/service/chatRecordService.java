package com.eul.eulproject.service;

import com.eul.eulproject.entity.chat.Record;

import java.util.List;

public interface chatRecordService {

    List<Record> getByUid(String Uid);

    List<Record> getRecord(String friendId,String myId);

    boolean insert(Record record);
}
