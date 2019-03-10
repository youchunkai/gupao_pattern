package com.gupaoedu.singleton.lazy;

/**
 * Author:KEVIN
 * Time:2019/3/10
 */
public class LazyInnerClassSingleton {

    private LazyInnerClassSingleton() { }

    public static LazyInnerClassSingleton getInstance(){

        return LazyHolder.LAZY;
    }

    private static class LazyHolder{
        private static final LazyInnerClassSingleton LAZY = new LazyInnerClassSingleton();
    }


    //此处我从网上看了写资料 然后写了一个demo  outer
    //理解了 静态内部类  静态代码块执行顺序
    //当类第一次被加载的时候  静态代码块会执行一次,后期不再执行
    //当类被加载的时候,其内部类并不会被同时加载
    //只有当加载了内部类的时候,内部类才会被加载,然后执行顺序依赖和类加载的顺序一样,先加载静态代码块

    //所以就起到了 延迟加载的作用,但同时又保证了实例的唯一性  懒加载饿汉式

    //时序图应该是getInstance() ==> 加载静态内部类 ==>调用单例构造方法\初始化常量 ==> 返回

}
