package com.gupaoedu.proxy.staticProxy;

/**
 * Author:KEVIN
 * Time:2019/3/14
 */
public class StaticProxyTest {

    public static void main(String[] args) {
        Person father = new Father(new Son());
        father.findLove();
    }
}
