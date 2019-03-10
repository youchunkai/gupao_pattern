package com.gupaoedu.factory.factoryMethod;

import com.gupaoedu.factory.simpleFactory.H5Course;
import com.gupaoedu.factory.simpleFactory.ICourse;

/**
 * Author:KEVIN
 * Time:2019/3/7
 */
public class H5Factory implements ICourseFactory {
    @Override
    public ICourse create() {
        return new H5Course();
    }
}
