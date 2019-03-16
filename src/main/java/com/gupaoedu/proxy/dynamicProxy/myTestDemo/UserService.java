package com.gupaoedu.proxy.dynamicProxy.myTestDemo;

/**
 * Author:KEVIN
 * Time:2019/3/14
 */
public class UserService implements IServiceLogger{

    public void methodA(){
        System.out.println("调用方法A");
    }

    public void methodB(){
        System.out.println("调用方法B");
    }


    public void methodC(){
        System.out.println("调用方法C");
    }

    @Override
    public void logger() {
        
    }
}
