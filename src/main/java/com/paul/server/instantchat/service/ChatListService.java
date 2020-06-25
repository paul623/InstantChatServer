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
