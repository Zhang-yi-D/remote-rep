package com.bean;

public class Result<T> {
    //success方法
    public static Result<Object> success(Object data){
     Result<Object> result = new Result<>();
     ResultCode success = ResultCode.SUCESS;
     result.setCode(success.code);
     result.setMsg(success.msg);
     result.setData(data);
     return  result;
    }
    //error方法

    //code
    private int code;

    //msg
    private String msg;
    //data
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
