package com.gupaoedu.factory.abstractFactory;

/**
 * Author:KEVIN
 * Time:2019/3/7
 */
public class DsjCourse implements ICourse {
    @Override
    public void teach() {
        System.out.println("教授大数据课程");
    }
}
