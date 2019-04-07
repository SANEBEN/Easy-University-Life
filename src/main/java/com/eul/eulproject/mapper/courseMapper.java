package com.eul.eulproject.mapper;

import com.eul.eulproject.entity.course.course;
import com.eul.eulproject.entity.course.coursesSimple;
import com.eul.eulproject.entity.information.message;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Repository
public interface courseMapper {

    @Select("SELECT * FROM eul.course where id = #{id}")
    @Results({
            @Result(column = "id" ,property = "id" ,jdbcType =  JdbcType.SMALLINT ,id = true),
            @Result(column = "name" ,property = "name" ,jdbcType = JdbcType.VARCHAR),
            @Result(column = "teacher" ,property = "Tid" ,jdbcType = JdbcType.SMALLINT),
            @Result(column = "teacher" ,property = "teacher" ,javaType = message.class ,
            one = @One(select = "com.eul.eulproject.mapper.messageMapper.getByUid")),
            @Result(column = "begin" ,property = "begin" ,jdbcType = JdbcType.SMALLINT),
            @Result(column = "end" ,property = "end" ,jdbcType = JdbcType.SMALLINT),
            @Result(column = "place" ,property = "place" ,jdbcType = JdbcType.VARCHAR),
            @Result(column = "volume" ,property = "volume" ,jdbcType = JdbcType.SMALLINT),
            @Result(column = "credit" ,property = "credit" ,jdbcType = JdbcType.SMALLINT),
            @Result(column = "time_begin" ,property = "time_begin" ,jdbcType = JdbcType.SMALLINT),
            @Result(column = "time_end" ,property = "time_end" ,jdbcType = JdbcType.SMALLINT),
            @Result(column = "type" ,property = "type" ,jdbcType = JdbcType.TINYINT)
    })
    course getByID(String id);

    @Select("SELECT ID, name, teacher FROM eul.course where id = #{id}")
    @Results({
            @Result(column = "id" ,property = "id" ,jdbcType =  JdbcType.SMALLINT ,id = true),
            @Result(column = "name" ,property = "name" ,jdbcType = JdbcType.VARCHAR),
            @Result(column = "teacher" ,property = "Tid" ,jdbcType = JdbcType.SMALLINT),
            @Result(column = "teacher" ,property = "teacher" ,javaType = String.class,
            one = @One(select = "com.eul.eulproject.mapper.messageMapper.getName"))
    })
    coursesSimple getSimpleByID(String ID);
}
