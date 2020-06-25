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
import com.paul.server.instantchat.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//好友管理模块
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
