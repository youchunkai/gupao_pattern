package com.gupaoedu.proxy.staticProxy;

/**
 * Author:KEVIN
 * Time:2019/3/14
 */
public class Father implements Person{
    Person son;

    public Father(Son son) {
        this.son = son;
    }


    @Override
    public void findLove() {
        before();
        son.findLove();
        after();
    }

    public void before(){
        System.out.println("找对象之前");
    }

    public void after(){
        System.out.println("找对象之后");
    }
}
