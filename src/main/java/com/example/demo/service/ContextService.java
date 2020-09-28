package com.example.demo.service;

import com.example.demo.bean.Context;

import java.util.Date;
import java.util.List;

public interface ContextService {
    List<Context> getContext();
    boolean addContext(String username, String context, Date time);
}
