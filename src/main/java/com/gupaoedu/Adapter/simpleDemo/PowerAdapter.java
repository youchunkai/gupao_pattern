package com.gupaoedu.Adapter.simpleDemo;

/**
 * Author:KEVIN
 * Time:2019/3/21
 */
public class PowerAdapter implements DC5 {

    private AC220 ac220;

    public PowerAdapter(AC220 ac220) {
        this.ac220 = ac220;
    }

    @Override
    public int output5V() {
        int adapterInput = ac220.outPut220V();
        int adapterOutput = adapterInput / 44;
        System.out.println("输入交流电压"+adapterInput+"V,输出直流电压"+adapterOutput+"V");
        return adapterOutput;
    }
}
