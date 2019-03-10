package com.gupaoedu.singleton.lazy;

/**
 * Author:KEVIN
 * Time:2019/3/10
 */
public class LazySimpleSingletonTest {

    public static void main(String[] args) {
        //LazySimpleSingleton lazySimpleSingleton = LazySimpleSingleton.getInstance();

        Thread thread1 = new Thread(new Executor());
        Thread thread2 = new Thread(new Executor());

        thread1.start();
        thread2.start();
    }
}
