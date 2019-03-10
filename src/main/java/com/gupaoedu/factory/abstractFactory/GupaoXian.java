package com.gupaoedu.factory.abstractFactory;

/**
 * Author:KEVIN
 * Time:2019/3/7
 */
public class GupaoXian implements IGupao {



    @Override
    public ICourse createCourse() {
        System.out.println("在西安");
        return new PythonCourse();  //然后这里想要实现 各种课程 没有实现  好像真的是如果多了一个产品 就要修改很多地方

        //另外uml图我弄出来的是 一个个单一的类,没有具体实现 或者调用的线
    }

    @Override
    public IActivity createActivity() {
        System.out.println("在西安");
        return new exchangeActivity();
    }
}
