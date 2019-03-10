package com.gupaoedu.singleton.lazy;

/**
 * Author:KEVIN
 * Time:2019/3/10
 */
public class LazyDoubleCheckSingleton {

    private static LazyDoubleCheckSingleton lazyDoubleCheckSingleton = null;

    private LazyDoubleCheckSingleton(){}

    public static LazyDoubleCheckSingleton getInstance()  {

        if(lazyDoubleCheckSingleton==null){
            synchronized (LazySimpleSingleton.class){ //但是这样每次都锁住 也影响性能,因为在外层可以再判断一下 单例是否存在,如果存在,直接返回
                if(lazyDoubleCheckSingleton==null){
                    lazyDoubleCheckSingleton = new LazyDoubleCheckSingleton();
                }
            }
        }
        return lazyDoubleCheckSingleton;
    }
}
