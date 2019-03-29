package com.eul.eulproject.service;

import com.eul.eulproject.entity.chat.Record;

import java.util.List;

public interface chatRecordService {

    List<Record> getByUid(String Uid);

    boolean insert(Record record);
}
