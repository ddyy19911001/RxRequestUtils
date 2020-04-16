package com.dy.myrequestutils;


public class BaseOkInfo  {

    /**
     * code : 200
     * msg : success
     * time : 1582007937
     * data :
     */

    private int code;
    private String msg;
    private int time;
    private String data;

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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
