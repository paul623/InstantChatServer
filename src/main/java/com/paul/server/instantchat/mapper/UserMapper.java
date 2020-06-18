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
}
