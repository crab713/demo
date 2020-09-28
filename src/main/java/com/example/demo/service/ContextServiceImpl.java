package com.example.demo.service;

import com.example.demo.bean.Context;
import com.example.demo.mapper.ContextMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ContextServiceImpl implements ContextService{
    @Autowired
    ContextMapper contextMapper;

    @Override
    public List<Context> getContext() {
        return contextMapper.getContext();
    }

    @Override
    public boolean addContext(String username, String context, Date time) {
        List<Context> list=contextMapper.getContext();
        int size=list.size();
        contextMapper.addContext(username,context,time);
        list=contextMapper.getContext();
        return list.size()>size;
    }
}
