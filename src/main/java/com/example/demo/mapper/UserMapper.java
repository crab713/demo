package com.example.demo.mapper;

import com.example.demo.bean.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {

    @Select("SELECT * FROM user WHERE username = #{name} AND password = #{password}")
    User getInfo(String name, String password);

    @Select("SELECT * FROM user WHERE username = #{name}")
    User getWithName(String name);

    @Select("INSERT INTO user (username, password) VALUES (#{name},#{password})")
    Integer register(String name,String password);
}
