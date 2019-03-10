package com.gupaoedu.singleton.lazy;

/**
 * Author:KEVIN
 * Time:2019/3/10
 */
public class Executor implements Runnable {
    @Override
    public void run() {
        LazySimpleSingleton lazySimpleSingleton = LazySimpleSingleton.getInstance();
        System.out.println(lazySimpleSingleton);
    }
}
