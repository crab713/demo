package com.example.demo.service;

import com.example.demo.bean.User;

public interface UserService {
    User loginIn(String name, String password);
    User register(String name,String password);
}
