/*
 * Copyright 2020 Paul623. https://github.com/paul623
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
   http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
 limitations under the License.
 */
package com.paul.server.instantchat.service;

import com.paul.server.instantchat.entity.MessageBean;
import com.paul.server.instantchat.entity.User;
import com.paul.server.instantchat.mapper.UserInfoMapper;
import com.paul.server.instantchat.mapper.UserMapper;
import com.paul.server.instantchat.tools.DateTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserInfoMapper userInfoMapper;

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
                        return new MessageBean(1,"登陆成功",user);
                    }else {
                        return new MessageBean(0,"更新账户状态失败，请重试",null);
                    }
                }else {
                    return new MessageBean(0,"密码错误",null);
                }
            }
        }

    }

    public MessageBean register(String phoneNumber,String password,String name,String sex,String birth,String sign,String email){
        try {
            Date date= DateTools.String2Date(birth);
            int result=userMapper.addUser(phoneNumber,password,new Date(),new Date());
            if(result!=0){
                User user=userMapper.getUser(phoneNumber);
                userInfoMapper.addUserInfo(user.getId(),name,sex,date,sign,email);
                return new MessageBean(1,"注册成功",userMapper.getUser(phoneNumber));
            }else {
                return new MessageBean(0,"注册失败，添加用户表异常",null);
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return new MessageBean(0,"注册失败，日期非法",null);
        }
    }

    public MessageBean rePassword(String uid,String passwd){
        int result=userMapper.updatePassword(passwd,uid);
        if(result==0){
            return new MessageBean(0,"修改失败！",null);
        }else {
            return new MessageBean(1,"修改成功！",null);
        }
    }
}
