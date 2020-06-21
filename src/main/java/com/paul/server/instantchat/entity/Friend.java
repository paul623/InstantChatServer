package com.paul.server.instantchat.entity;

import java.io.Serializable;
import java.util.Date;

public class Friend implements Serializable {
    int id;
    int userId;
    int friendId;
    String friendName;
    Date CombineDate;

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    public Date getCombineDate() {
        return CombineDate;
    }

    public void setCombineDate(Date combineDate) {
        CombineDate = combineDate;
    }
}
