package com.gupaoedu.factory.abstractFactory;

/**
 * Author:KEVIN
 * Time:2019/3/7
 */
public class AbstractFactoryTest {


    public static void main(String[] args) {
        IGupao xa = new GupaoXian();
        xa.createCourse().teach();
        xa.createActivity().hold();

        IGupao cs = new GupaoChangsha();
        cs.createActivity().hold();
        cs.createCourse().teach();
    }
}
