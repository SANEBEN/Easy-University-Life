package com.eul.eulproject.mapper;

import com.eul.eulproject.entity.major;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface majorMapper {

    @Select("Select * from eul.major where ID = #{ID}")
    major getByID(String ID);
}
