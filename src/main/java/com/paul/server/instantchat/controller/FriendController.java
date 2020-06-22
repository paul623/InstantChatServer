package com.paul.server.instantchat.controller;

import com.paul.server.instantchat.entity.MessageBean;
import com.paul.server.instantchat.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Controller
public class FriendController {
    @Autowired
    FriendService friendService;

    @RequestMapping("friend/getList")
    public MessageBean getMyFriendList(String uid){
        try {
            int i = Integer.parseInt(uid);
            return friendService.getFriendList(i);
        }catch (Exception e){
            return new MessageBean(0,"解析失败",null);
        }

    }
    @RequestMapping("friend/addFriend")
    public MessageBean addFriend(String uid,String fid){
        try {
            return friendService.addFriends(Integer.parseInt(uid),Integer.parseInt(fid));
        }catch (Exception e){
            return new MessageBean(0,"解析失败"+e,null);
        }

    }
    @RequestMapping("friend/deleteFriend")
    public MessageBean deleteFriend(String uid,String fid){
        try {
            return friendService.deleteFriends(Integer.parseInt(uid),Integer.parseInt(fid));
        }catch (Exception e){
            return new MessageBean(0,"解析失败"+e,null);
        }
    }

}
