package com.paul.server.instantchat.service;

import com.paul.server.instantchat.entity.Chatlist;
import com.paul.server.instantchat.entity.MessageBean;
import com.paul.server.instantchat.mapper.ChatListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ChatListService {
    @Autowired
    ChatListMapper chatListMapper;

    public MessageBean getChatListById(String uid,String fid){
        return new MessageBean(1,"获取成功！",chatListMapper.getChatListById(uid,fid));
    }

    public MessageBean addChatList(String content, int sendId, int receiveId){
        int result=chatListMapper.addChatList(content,sendId,receiveId,new Date(),1);
        if(result==0){
            return new MessageBean(0,"发送失败",content);
        }else {
            return new MessageBean(1,"发送成功",content);
        }
    }

    public MessageBean getNewMessage(int uid){
        List<Chatlist> chatlists=chatListMapper.getNewMessage(uid);
        if(chatlists==null||chatlists.isEmpty()){
            return new MessageBean(0,"暂无新消息",null);
        }else {
            for(Chatlist chatlist:chatlists){
                chatListMapper.setChatListStatus(chatlist.getId());
            }
            return new MessageBean(1,"收到新消息啦！",chatlists);
        }
    }

}
