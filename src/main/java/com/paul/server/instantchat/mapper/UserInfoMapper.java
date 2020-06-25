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

import com.paul.server.instantchat.entity.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.Date;

@Mapper
public interface UserInfoMapper {

    @Insert("insert into userinfo values(#{id},#{name},#{sex},#{birth},#{sign},#{email})")
    public int addUserInfo(int id, String name, String sex, Date birth,String sign,String email);
    @Update("update userinfo set name=#{name},sex=#{sex},birth=#{birth},sign=#{sign},email=#{email} where id=#{id}")
    public int updateUserInfo(int id,String name,String sex,Date birth,String sign,String email);

    @Select("select * from userinfo where id=#{uid}")
    public UserInfo getUserInfoById(int uid);

    @Select("select name from userinfo where id=#{uid}")
    public String getUserNameById(int uid);


}
