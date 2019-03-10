package com.gupaoedu.singleton.hungry;

/**
 * Author:KEVIN
 * Time:2019/3/10
 */
public class HungrySingleton {

    private static final HungrySingleton hungrySingleton = new HungrySingleton();

    //单例就是私有化构造方法,然后提供一个可供全局访问,获得实例的方法
    private HungrySingleton() { }

    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }


    //恶汉式单例 是在类在初始化的时候就会创建
    //类在初始化的时候,是线程安全的,这个单例能够保证全局唯一,
    //但是如果全局有很多饿汉式单例的话,有可能造成内存上的浪费
}
