package com.gupaoedu.factory.abstractFactory;

/**
 * Author:KEVIN
 * Time:2019/3/7
 */
public class GupaoChangsha implements IGupao {

    @Override
    public ICourse createCourse() {
        System.out.println("在长沙");
        return new PythonCourse();
    }

    @Override
    public IActivity createActivity() {
        System.out.println("在长沙");
        return new exchangeActivity();
    }
}
