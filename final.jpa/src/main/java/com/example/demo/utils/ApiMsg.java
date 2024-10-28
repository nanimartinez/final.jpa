package com.example.demo.utils;

public class ApiMsg {

    private String message;
    private Object data;

    public ApiMsg(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

}
