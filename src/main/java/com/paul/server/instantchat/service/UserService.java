package com.paul.server.instantchat.service;

import com.paul.server.instantchat.entity.MessageBean;
import com.paul.server.instantchat.entity.User;
import com.paul.server.instantchat.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public MessageBean login(String phoneNumber,String password){
        User user=userMapper.getUser(phoneNumber);
        if(user==null){
            return new MessageBean(0,"用户不存在！",null);
        }else {
            if(password==null){
                return new MessageBean(0,"密码不能为空",null);
            }else {
                if(password.equals(user.getPassword())){
                    int i=userMapper.updateLoginDate(phoneNumber,new Date());
                    if(i==1){
                        return new MessageBean(1,"登录成功！",user);
                    }else {
                        return new MessageBean(0,"更新账户状态失败，请重试",null);
                    }
                }else {
                    return new MessageBean(0,"密码错误",null);
                }
            }
        }

    }
}
