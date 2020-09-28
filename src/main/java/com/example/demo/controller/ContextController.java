package com.example.demo.controller;

import com.example.demo.bean.Context;
import com.example.demo.service.ContextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
public class ContextController {

    @Autowired
    ContextService contextService;

    @RequestMapping("/context")
    public String context(){
        return "context";
    }

    @RequestMapping("/getContext")
    @ResponseBody
    public List<Context> getContext(){
        return contextService.getContext();
    }

    @ResponseBody
    @RequestMapping("/addContext")
    public Map addContext(@RequestParam("username")String username,
                          @RequestParam("context")String context
                          ){

        Map<String,String> state=new HashMap<>();
        Date time=new Date();
        if(contextService.addContext(username,context,time)){
            state.put("res","200");
            state.put("message","提交成功");
        }else {
            state.put("res","400");
            state.put("message","提交失败");
        }
        return state;
    }
}
