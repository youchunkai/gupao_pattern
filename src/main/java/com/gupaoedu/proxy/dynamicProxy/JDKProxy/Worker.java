package com.gupaoedu.proxy.dynamicProxy.JDKProxy;

/**
 * Author:KEVIN
 * Time:2019/3/14
 */
public class Worker implements Person {

    @Override
    public void findJob() {
        System.out.println("开始找工作");
    }
}
