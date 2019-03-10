package com.gupaoedu.factory.abstractFactory;

/**
 * Author:KEVIN
 * Time:2019/3/7
 */
public class exchangeActivity implements IActivity {
    @Override
    public void hold() {
        System.out.println("举行线下交流活动");
    }
}
