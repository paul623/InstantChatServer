package com.paul.server.instantchat.service;

import com.paul.server.instantchat.entity.MessageBean;
import com.paul.server.instantchat.entity.UserInfo;
import com.paul.server.instantchat.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;


    public MessageBean getUserInfoById(int uid){
        UserInfo userInfo=userInfoMapper.getUserInfoById(uid);
        if(userInfo==null){
            return new MessageBean(0,"查无此人",null);
        }
        return new MessageBean(1,"成功",userInfo);
    }
}
