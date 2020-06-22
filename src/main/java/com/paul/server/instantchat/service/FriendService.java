package com.paul.server.instantchat.service;

import com.paul.server.instantchat.entity.Friend;
import com.paul.server.instantchat.entity.MessageBean;
import com.paul.server.instantchat.mapper.FriendMapper;
import com.paul.server.instantchat.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FriendService {
    @Autowired
    FriendMapper friendMapper;
    @Autowired
    UserInfoMapper userInfoMapper;


    public MessageBean getFriendList(int userId){
        return new MessageBean(1,"获取成功！",friendMapper.getMyFriendList(userId));
    }

    public MessageBean addFriends(int userId,int friendId){
        if(userInfoMapper.getUserInfoById(friendId)==null){
            return new MessageBean(0,"该用户不存在！",null);
        }
        if(friendMapper.getFriendByUFId(userId, friendId)!=null){
            return new MessageBean(0,"不得重复添加！",null);
        }
        friendMapper.addFriend(userId,friendId,userInfoMapper.getUserInfoById(friendId).getName(),new Date());
        friendMapper.addFriend(friendId,userId,userInfoMapper.getUserInfoById(userId).getName(),new Date());
        return new MessageBean(1,"成功！",getFriendList(userId));
    }

    public MessageBean deleteFriends(int userId,int friendId){
        if(friendMapper.deleteFriend(userId,friendId)==1){
            if(friendMapper.deleteFriend(friendId,userId)==1){
                return new MessageBean(1,"删除成功！",null);
            }else {
                return new MessageBean(0,"删除失败！",null);
            }
        }else {
            return new MessageBean(0,"删除失败！",null);
        }
    }
}
