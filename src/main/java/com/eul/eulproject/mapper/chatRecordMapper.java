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

    @Insert("insert into eul.chatrecord(ID, `FROM`, `TO`, time, content) VALUES (#{ID} ,#{FROM} ,#{TO} ,#{time} ,#{content})")
    boolean insert(Record record);
}
