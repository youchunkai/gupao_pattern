package com.gupaoedu.factory.abstractFactory;

/**
 * Author:KEVIN
 * Time:2019/3/7
 */
public class PythonCourse implements ICourse {
    @Override
    public void teach() {
        System.out.println("教授Python课程");
    }
}
