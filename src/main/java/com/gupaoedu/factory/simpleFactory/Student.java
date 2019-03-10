package com.gupaoedu.factory.simpleFactory;

/**
 * Author:KEVIN
 * Time:2019/3/7
 */
public class Student {

    ICourse course; //面向接口编程 依赖倒置原则

    public void study(ICourse course){
        course.study();
    }


}
