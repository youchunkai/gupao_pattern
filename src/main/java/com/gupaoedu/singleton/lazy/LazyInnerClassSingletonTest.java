package com.gupaoedu.singleton.lazy;

/**
 * Author:KEVIN
 * Time:2019/3/10
 */
public class LazyInnerClassSingletonTest {

    public static void main(String[] args) {
        LazyInnerClassSingleton lazy = LazyInnerClassSingleton.getInstance();

        System.out.println(lazy);
    }
}
