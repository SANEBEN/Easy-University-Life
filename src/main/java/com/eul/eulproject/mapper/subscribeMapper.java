package com.eul.eulproject.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface subscribeMapper {

    @Insert("insert into eul.subscribe(author, customer) VALUES (#{author},#{customer})")
    boolean add(int author ,int customer);

    @Select("SELECT customer from eul.subscribe where author = #{author}")
    List<String> get(int author);
}
