package com.eul.eulproject.mapper;

import com.eul.eulproject.entity.information.login;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginMapper {

    @Select("SELECT count(*) FROM eul.login where loginName = #{logInName} ,password = #{password}")
    int login(String logInName ,String password);

    @Select("SELECT * FROM eul.login where loginName = #{Name}")
    login getByName(String Name);

    @Update("UPDATE eul.login set password = #{password} where ID = #{ID}")
    boolean update(String ID ,String password);

    @Select("SELECT * FROM eul.login")
    List<login> getAll();
}
