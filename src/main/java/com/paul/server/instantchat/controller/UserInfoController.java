package com.paul.server.instantchat.controller;

import com.paul.server.instantchat.entity.MessageBean;
import com.paul.server.instantchat.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Controller
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping("userInfo/getInfo")
    public MessageBean getUserInfoByUid(String uid){
        return userInfoService.getUserInfoById(Integer.parseInt(uid));
    }
}
