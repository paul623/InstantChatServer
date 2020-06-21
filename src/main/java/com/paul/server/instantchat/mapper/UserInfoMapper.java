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
    @Update("update userinfo set name ={#name},sex=#{sex},birth=#{birth},sign=#{sign},email=#{email} where id=#{id}")
    public int updateUserInfo(int id,String name,String sex,Date birth,String sign,String email);

    @Select("select * from userinfo where id=#{uid}")
    public UserInfo getUserInfoById(int uid);

    @Select("select name from userinfo where id=#{uid}")
    public String getUserNameById(int uid);
}
