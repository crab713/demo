package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
@CrossOrigin
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String show(){
        return "login";
    }

    @ResponseBody
    @RequestMapping(value = "/loginIn")
    public Map login(@RequestParam(value = "name",required = false) String name,
                              @RequestParam(value = "password",required = false) String password,
                              HttpServletResponse response
    ){
        User user=userService.loginIn(name,password);
        Map<String,String> state=new HashMap<>();
        if(user !=null){
            Cookie cookie=new Cookie("name",name);
            cookie.setMaxAge(60);
            response.addCookie(cookie);
            state.put("res","200");
            state.put("message","登陆成功");
        }else {
            state.put("res","400");
            state.put("message","登陆失败");
        }
        return state;
    }

    @ResponseBody
    @RequestMapping(value = "/register")
    public Map register(@RequestParam(value = "name")String name,
                           @RequestParam(value = "password")String password){
        User user = userService.register(name,password);
        Map<String,String> state=new HashMap<>();
        if(user !=null){
            state.put("res","200");
            state.put("message","注册成功");
        }else {
            state.put("res","400");
            state.put("message","注册失败");
        }
        return state;
    }
}
