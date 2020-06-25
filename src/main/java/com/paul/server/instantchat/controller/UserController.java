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
package com.paul.server.instantchat.controller;

import com.paul.server.instantchat.entity.MessageBean;
import com.paul.server.instantchat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//用户管理模块
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
