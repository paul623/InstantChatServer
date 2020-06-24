package com.paul.server.instantchat.service;

import com.paul.server.instantchat.entity.MessageBean;
import com.paul.server.instantchat.entity.UserInfo;
import com.paul.server.instantchat.mapper.UserInfoMapper;
import com.paul.server.instantchat.tools.DateTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
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

    public MessageBean updateUserInfo(int id, String name, String sex, String birth, String sign, String email){
        int result= 0;
        try {
            result = userInfoMapper.updateUserInfo(id, name, sex, DateTools.String2Date(birth), sign, email);
            if(result==1){
                return new MessageBean(1,"更新成功！",getUserInfoById(id));
            }else {
                return new MessageBean(0,"更新失败，数据库异常",null);
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return new MessageBean(0,"更新失败，解析失败",null);
        }


    }
}
