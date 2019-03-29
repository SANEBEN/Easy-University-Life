package com.eul.eulproject.mapper;

import com.eul.eulproject.entity.friends.friendSimple;
import com.eul.eulproject.entity.friends.friend;
import com.eul.eulproject.entity.information.message;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface friendsMapper {

    @Select("SELECT friend from eul.friend where Uid = #{Uid}")
    @Results({
            @Result(column = "friend" ,property = "ID" ,jdbcType = JdbcType.SMALLINT ,id = true),
            @Result(column = "friend" ,property = "friend" ,javaType = message.class ,
            one = @One(select = "com.eul.eulproject.mapper.messageMapper.getAsFriend"))
    })
    List<friend> getByUid_simple(String Uid);

    @Select("SELECT friend from eul.friend where Uid = #{Uid}")
    @Results({
            @Result(column = "friend" ,property = "ID" ,jdbcType = JdbcType.SMALLINT ,id = true),
            @Result(column = "friend" ,property = "friend" ,javaType = message.class ,
                    one = @One(select = "com.eul.eulproject.mapper.messageMapper.getByUid"))
    })
    List<friend> getByUid_complete(String Uid);

    @Select("SELECT friend from eul.friend where Uid = #{Uid}")
    @Results({
            @Result(column = "friend" ,property = "ID" ,jdbcType = JdbcType.SMALLINT ,id = true),
            @Result(column = "friend" ,property = "name" ,javaType = message.class ,
                    one = @One(select = "com.eul.eulproject.mapper.messageMapper.getName"))
    })
    List<friendSimple> getSimpleFriends(String Uid);
}
