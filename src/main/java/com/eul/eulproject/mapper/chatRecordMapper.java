package com.eul.eulproject.mapper;

import com.eul.eulproject.entity.chat.Record;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface chatRecordMapper {

    @Select("SELECT * FROM eul.chatrecord where FROM_id = #{Uid}")
    List<Record> getByUid(String Uid);

    @Select("SELECT * FROM eul.chatrecord where FROM_id = #{myId} and TO_id = #{friendId}")
    List<Record> getRecord_from(String friendId,String myId);

    @Select("SELECT * FROM eul.chatrecord where FROM_id = #{friendId} and TO_id = #{myId}")
    List<Record> getRecord_to(String friendId,String myId);

    @Insert("insert into eul.chatrecord(FROM_id, TO_id, time, content) VALUES  (#{FROM_id} ,#{TO_id} ,#{time} ,#{content})")
    boolean insert(Record record);
}
