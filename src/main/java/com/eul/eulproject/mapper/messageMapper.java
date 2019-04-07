package com.eul.eulproject.mapper;

import com.eul.eulproject.entity.information.messageSimple;
import com.eul.eulproject.entity.major;
import com.eul.eulproject.entity.information.message;
import com.eul.eulproject.entity.school;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface messageMapper {

    @Select("SELECT * FROM eul.message where id = #{Uid}")
    @Results({
            @Result(column = "id" ,property = "id" ,jdbcType = JdbcType.SMALLINT ,id=true),
            @Result(column = "IDNumber" ,property = "IDNumber" ,jdbcType = JdbcType.VARCHAR),
            @Result(column = "realName" ,property = "realName" ,jdbcType = JdbcType.VARCHAR),
            @Result(column = "school" ,property = "Sid" ,jdbcType = JdbcType.SMALLINT),
            @Result(column = "school" ,property = "school" ,javaType = school.class ,
            one = @One(select = "com.eul.eulproject.mapper.schoolMapper.getByID")),
            @Result(column = "major" ,property = "Mid" ,jdbcType = JdbcType.SMALLINT),
            @Result(column = "major" ,property = "major" ,javaType = major.class ,
            one = @One(select = "com.eul.eulproject.mapper.majorMapper.getByID")),
            @Result(column = "gender" ,property = "gender" ,jdbcType = JdbcType.TINYINT),
            @Result(column = "email" ,property = "email" ,jdbcType = JdbcType.VARCHAR),
            @Result(column = "createdTime" ,property = "createdTime" ,jdbcType = JdbcType.DATETIMEOFFSET),
            @Result(column = "role" ,property = "role" ,jdbcType = JdbcType.TINYINT)
    })
    message getByUid(String Uid);

    @Select("Select IDNumber, realName, school, major, gender, email from eul.message where id = #{Uid}")
    message getAsFriend(String Uid);

    @Select("SELECT realName from eul.message where id = #{Uid}")
    String getName(String Uid);

    @Select("SELECT ID, IDNumber, realName, role FROM eul.message where id = #{Uid}")
    messageSimple getSimpleMessage(String Uid);
}
