package com.paul.server.instantchat.controller;

import com.paul.server.instantchat.entity.MessageBean;
import com.paul.server.instantchat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("user/login")
    public MessageBean login(String phoneNumber,String password){
        return userService.login(phoneNumber, password);
    }

    @PostMapping("user/register")
    public MessageBean register(String phoneNumber,String password,String name,String sex,String birth,String sign,String email){
        return userService.register(phoneNumber, password, name, sex, birth, sign, email);
    }
    @PostMapping("user/rePasswd")
    public MessageBean rePassWord(String uid,String password){
        return userService.rePassword(uid,password);
    }

}
