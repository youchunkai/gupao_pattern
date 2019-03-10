package com.gupaoedu.factory.simpleFactory;

/**
 * Author:KEVIN
 * Time:2019/3/7
 */
public class SimpleFactoryTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Student student= new Student();
        CourseFactory cf = new CourseFactory();
        ICourse course = cf.createCourse(JavaCourse.class);
        ICourse course1 = cf.createCourse(H5Course.class);
        student.study(course);
        student.study(course1);
    }
}
