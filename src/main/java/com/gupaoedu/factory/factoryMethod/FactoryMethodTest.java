package com.gupaoedu.factory.factoryMethod;

import com.gupaoedu.factory.simpleFactory.Student;

/**
 * Author:KEVIN
 * Time:2019/3/7
 */
public class FactoryMethodTest {

    public static void main(String[] args) {
        Student student = new Student();
        ICourseFactory javaFactory = new JavaFactory();
        student.study(javaFactory.create());

        ICourseFactory h5factory = new H5Factory();
        student.study(h5factory.create());
    }

    //相对简单工厂来说  工厂方法在创建具体课程对象的时候 是交给具体的课程实现类去完成
    //这样 我们就方便 对一些特殊的课程 进行定制化的创建  比如java课程要打折
    //而再简单工厂里 由于都是走固定的创建流程,如果需要定制化,那么就需要 在create()里 进行判断
    //顶层接口(类)就不用承担太多的实际业务  满足开闭原则的同时,又有点精细化职责(单一职责?不太像,但又有点这个意思)  专业的人干专业的事

}
