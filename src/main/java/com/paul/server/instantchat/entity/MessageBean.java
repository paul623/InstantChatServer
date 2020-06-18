package com.paul.server.instantchat.entity;

import org.springframework.stereotype.Service;

import java.io.Serializable;

public class MessageBean implements Serializable {
    int code;
    Object data;

    public MessageBean(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
