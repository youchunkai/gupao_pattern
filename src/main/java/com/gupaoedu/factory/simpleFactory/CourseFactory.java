package com.gupaoedu.factory.simpleFactory;

/**
 * Author:KEVIN
 * Time:2019/3/7
 */
public class CourseFactory {

    public ICourse createCourse(Class<?> clz) throws IllegalAccessException, InstantiationException {

        //工厂 比new的方式 优势在这里也可以体现,一些标准化的逻辑可以在这里进行编写
        //而 new的话 就得在每个构造方法里 或其他地方去实现
        //比方说 某个接口的实现类 在创建前 都要监控一下日志

        return (ICourse) clz.newInstance();

    }


}
