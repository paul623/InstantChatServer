package com.paul.server.instantchat.mapper;

import com.paul.server.instantchat.entity.Friend;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface FriendMapper {
    @Select("select * from friend where userId=#{userId}")
    public List<Friend> getMyFriendList(int userId);

    @Insert("insert into friend(userId,friendId,friendName,CombineDate) values(#{userId},#{friendId},#{friendName},#{date}) ")
    public int addFriend(int userId, int friendId,String friendName, Date date);

    @Select("select * from friend where userId=#{userId} and friendId=#{friendId}")
    public Friend getFriendByUFId(int userId,int friendId);

    @Delete("delete from friend where where userId=#{userId} and friendId=#{friendId}")
    public int deleteFriend(int userId, int friendId);
}
