package com.gupaoedu.factory.simpleFactory;

/**
 * Author:KEVIN
 * Time:2019/3/7
 */
public class H5Course implements ICourse {
    @Override
    public void study() {
        System.out.println("学习H5课程");
    }
}
