package com.paul.server.instantchat.controller;

import com.paul.server.instantchat.entity.MessageBean;
import com.paul.server.instantchat.service.ChatListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.RequestWrapper;

@Controller
@ResponseBody
public class ChatListController {
    @Autowired
    ChatListService chatListService;

    @RequestMapping("chat/getList")
    public MessageBean getChatList(String uid,String fid){
        return chatListService.getChatListById(uid,fid);
    }
    @RequestMapping("chat/sendMessage")
    public MessageBean sendMessage(String content, int sendId, int receiveId){
        return chatListService.addChatList(content, sendId, receiveId);
    }

    @RequestMapping("chat/checkNewMessage")
    public MessageBean checkForNewMessage(int uid){
        return chatListService.getNewMessage(uid);
    }

}
