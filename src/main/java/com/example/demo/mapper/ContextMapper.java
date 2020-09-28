package com.example.demo.mapper;

import com.example.demo.bean.Context;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;


import java.util.Date;
import java.util.List;

@Component
public interface ContextMapper {
    @Select("SELECT * FROM context")
    List<Context> getContext();

    @Select("INSERT INTO context (username, context, time) VALUES (#{username},#{context},#{time})")
    void addContext(String username, String context, Date time);
}
