package com.gupaoedu.factory.factoryMethod;

import com.gupaoedu.factory.simpleFactory.ICourse;
import com.gupaoedu.factory.simpleFactory.JavaCourse;

/**
 * Author:KEVIN
 * Time:2019/3/7
 */
public class JavaFactory implements ICourseFactory {
    @Override
    public ICourse create() {
        System.out.println("java课程限时优惠哦!!!");
        return new JavaCourse();
    }
}
