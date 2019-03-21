package com.gupaoedu.Adapter.loginadapter.v1;

/**
 * Author:KEVIN
 * Time:2019/3/21
 */
public class Member {

    private String usname;
    private String pwd;
    private String mid;
    private String info;

    public String getUsname() {
        return usname;
    }

    public Member setUsname(String usname) {
        this.usname = usname;
        return this;
    }

    public String getPwd() {
        return pwd;
    }

    public Member setPwd(String pwd) {
        this.pwd = pwd;
        return this;
    }

    public String getMid() {
        return mid;
    }

    public Member setMid(String mid) {
        this.mid = mid;
        return this;
    }

    public String getInfo() {
        return info;
    }

    public Member setInfo(String info) {
        this.info = info;
        return this;
    }
}
