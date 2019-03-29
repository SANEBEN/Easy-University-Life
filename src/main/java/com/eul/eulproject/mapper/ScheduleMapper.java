package com.eul.eulproject.mapper;

import com.eul.eulproject.entity.course.course;
import com.eul.eulproject.entity.schedule;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleMapper {

    @Select("SELECT course FROM eul.schedule where Uid = #{Uid}")
    @Results({
            @Result(column = "course" ,property = "ID" ,jdbcType = JdbcType.SMALLINT, id =true),
            @Result(column = "course" ,property = "course" ,javaType = course.class ,
            one = @One(select = "com.eul.eulproject.mapper.courseMapper.getByID"))
    })
    List<schedule> getByStudent(String Uid);

    @Select("SELECT course FROM eul.schedule where Uid = #{Uid}")
    List<String> getCourseList(String Uid);
}
