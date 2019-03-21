package com.gupaoedu.Adapter.loginadapter.v1;



/**
 * Author:KEVIN
 * Time:2019/3/21
 */
public class SiginService {


    public ResultMsg regist(String usname, String pwd) {
        return new ResultMsg(200, "注册成功",new Member().setUsname(usname).setPwd(pwd));
    }

    public ResultMsg login(String usname,String pwd){

        return new ResultMsg(200, "登陆成功", new Member().setUsname(usname).setPwd(pwd));

    }

}
