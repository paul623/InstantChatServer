package com.paul.server.instantchat.service;

import com.paul.server.instantchat.entity.MessageBean;
import com.paul.server.instantchat.entity.UserInfo;
import com.paul.server.instantchat.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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

    public String getUserName(int uid){
        return userInfoMapper.getUserNameById(uid);
    }

    public MessageBean updateUserInfo(int id, String name, String sex, Date birth, String sign, String email){
        int result=userInfoMapper.updateUserInfo(id, name, sex, birth, sign, email);
        if(result==1){
            return new MessageBean(1,"更新成功！",getUserInfoById(id));
        }else {
            return new MessageBean(0,"更新失败，数据库异常",null);
        }
    }
}
