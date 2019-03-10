package com.gupaoedu.singleton.lazy;

/**
 * Author:KEVIN
 * Time:2019/3/10
 */
public class LazySimpleSingleton {

    private static LazySimpleSingleton lazySimpleSingleton = null;

    private LazySimpleSingleton(){}

    public static LazySimpleSingleton getInstance()  {
        synchronized (LazySimpleSingleton.class){ //但是这样每次都锁住 也影响性能,因为在外层可以再判断一下 单例是否存在,如果存在,直接返回
            if(lazySimpleSingleton==null){
//            try {
//                Thread.sleep(1000);
//
//            }catch (Exception e){
//                e.printStackTrace();
//            }
                lazySimpleSingleton = new LazySimpleSingleton();
            }
        }
        return lazySimpleSingleton;
    }
}
