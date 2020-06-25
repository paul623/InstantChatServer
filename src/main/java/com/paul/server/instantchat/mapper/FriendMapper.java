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

    @Delete("delete from friend where  userId=#{userId} and friendId=#{friendId}")
    public int deleteFriend(int userId, int friendId);
}
