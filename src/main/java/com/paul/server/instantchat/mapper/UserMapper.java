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

import com.paul.server.instantchat.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;

@Mapper
public interface UserMapper {
    @Select("select * from user where phoneNumber=#{phoneNumber}")
    public User getUser(String phoneNumber);

    @Insert("insert into user(phoneNumber,password,registerDate,loginDate) values(#{phoneNumber},#{password},#{registerDate},#{loginDate}) ")
    public int addUser(String phoneNumber, String password, Date registerDate, Date loginDate);

    @Update("update user set loginDate = #{loginDate} where phoneNumber=#{phoneNumber}")
    public int updateLoginDate(String phoneNumber,Date loginDate);

    @Update("update user set password = #{password} where id=#{uid}")
    public int updatePassword(String password,String uid);
}
