package com.gupaoedu.template.course;

/**
 * Author:KEVIN
 * Time:2019/3/20
 */
public class courseDemo {

    public static void main(String[] args) {

        System.out.println("============java课程=============");
        JavaCourse javaCourse = new JavaCourse(true);
        javaCourse.createCourse();


        System.out.println("============大数据课程============");
        BigDataCourse bigDataCourse = new BigDataCourse(false);
        bigDataCourse.createCourse();
    }
}
