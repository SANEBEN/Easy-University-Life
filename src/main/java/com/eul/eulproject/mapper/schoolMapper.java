package com.eul.eulproject.mapper;

import com.eul.eulproject.entity.school;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface schoolMapper {

    @Select("SELECT * FROM eul.school where ID = #{Sid}")
    school getByID(String Sid);
}
