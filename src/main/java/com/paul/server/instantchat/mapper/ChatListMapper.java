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
package com.paul.server.instantchat.mapper;

import com.paul.server.instantchat.entity.Chatlist;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

@Mapper
public interface ChatListMapper {
    @Select("SELECT * FROM chatlist where (sendId=#{sendId} and receiveId=#{receiveId}) or (sendId=#{receiveId} and receiveId=#{sendId})")
    public List<Chatlist> getChatListById(String sendId, String receiveId);

    @Insert("insert into chatlist(content,sendId,receiveId,date,status) values(#{content},#{sendId},#{receiveId},#{date},#{status})")
    public int addChatList(String content, int sendId, int receiveId, Date date, int status);

    @Select("SELECT * FROM chatlist where receiveId=#{uid} and status='1'")
    public List<Chatlist> getNewMessage(int uid);

    @Update("update chatlist set status='0' where id=#{id} ")
    public int setChatListStatus(int id);
}
