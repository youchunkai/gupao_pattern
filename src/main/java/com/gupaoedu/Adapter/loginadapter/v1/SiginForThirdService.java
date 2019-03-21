package com.gupaoedu.Adapter.loginadapter.v1;

/**
 * Author:KEVIN
 * Time:2019/3/21
 */
public class SiginForThirdService extends SiginService {


    public ResultMsg loginForQQ(Object[] args){

        return loginForRegist(args);
    }

    private ResultMsg loginForRegist(Object[] args) {
        super.regist(args[0].toString(), null);
        return super.login(args[0].toString(), null);
    }

}
