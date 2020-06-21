package com.paul.server.instantchat.mapper;

import com.paul.server.instantchat.entity.Chatlist;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface ChatListMapper {
    @Select("SELECT * FROM chatlist where (sendId=#{sendId} and receiveId=#{receiveId}) or (sendId=#{receiveId} and receiveId=#{sendId})")
    public List<Chatlist> getChatListById(String sendId, String receiveId);

    @Insert("insert into chatlist(content,sendId,receiveId,date,status) values(#{content},#{sendId},#{receiveId},#{date},#{status})")
    public int addChatList(String content, int sendId, int receiveId, Date date, int status);
}
