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
import com.paul.server.instantchat.service.ChatListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.RequestWrapper;
//聊天管理模块
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
