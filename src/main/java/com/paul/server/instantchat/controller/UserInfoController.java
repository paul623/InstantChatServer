package com.paul.server.instantchat.controller;

import com.paul.server.instantchat.entity.MessageBean;
import com.paul.server.instantchat.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@ResponseBody
@Controller
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping("userInfo/getInfo")
    public MessageBean getUserInfoByUid(String uid){
        return userInfoService.getUserInfoById(Integer.parseInt(uid));
    }

    @RequestMapping("userInfo/getName")
    public String getNameById(String uid){
        return userInfoService.getUserName(Integer.parseInt(uid));
    }

    @RequestMapping("userInfo/edit")
    public MessageBean updateUserInfo(int id, String name, String sex, String birth, String sign, String email){
        return userInfoService.updateUserInfo(id, name, sex, birth, sign, email);
    }
}
