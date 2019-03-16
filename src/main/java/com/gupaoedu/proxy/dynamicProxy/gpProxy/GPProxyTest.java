package com.gupaoedu.proxy.dynamicProxy.gpProxy;

/**
 * Author:KEVIN
 * Time:2019/3/16
 */
public class GPProxyTest {

    public static void main(String[] args) {

        Person person = (Person) new GPMeipo().getProxyInstance(new Girl());
        person.findLove();
    }
}
