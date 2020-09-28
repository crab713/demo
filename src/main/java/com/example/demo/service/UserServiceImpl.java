package com.example.demo.service;

import com.example.demo.bean.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User loginIn(String name, String password) {
        return userMapper.getInfo(name,password);
    }

    @Override
    public User register(String name, String password) {
        User user=userMapper.getWithName(name);
        if(user == null){
            userMapper.register(name,password);
            user=userMapper.getWithName(name);
            return user;
        }else {
            return null;
        }
    }
}
