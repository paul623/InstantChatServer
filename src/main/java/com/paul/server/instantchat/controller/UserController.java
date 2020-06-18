package com.paul.server.instantchat.controller;

import com.paul.server.instantchat.entity.MessageBean;
import com.paul.server.instantchat.entity.User;
import com.paul.server.instantchat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/test")
    public MessageBean getUser(){
        return new MessageBean(1,userService.getUser());
    }
}
