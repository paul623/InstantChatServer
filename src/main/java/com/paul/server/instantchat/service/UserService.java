package com.paul.server.instantchat.service;

import com.paul.server.instantchat.entity.User;
import com.paul.server.instantchat.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User getUser(){
        return userMapper.getUser("17851559306");
    }
}
