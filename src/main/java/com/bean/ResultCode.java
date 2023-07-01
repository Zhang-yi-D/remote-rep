package com.bean;

public enum ResultCode {
    SUCESS(200,"一切ok"),NOTFOUND(404,"找不到资源"),
    SERVERERROR(500,"后端语法出现问题"),URLERROR(400,"前端url拼接问题");
    public int code;
    public String msg;
    private ResultCode(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
