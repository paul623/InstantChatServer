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
