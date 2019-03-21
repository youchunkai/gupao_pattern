package com.gupaoedu.Adapter.simpleDemo;

/**
 * Author:KEVIN
 * Time:2019/3/21
 */
public class SimpleAdaperTest {

    public static void main(String[] args) {
        int adapterOutput = new PowerAdapter(new AC220()).output5V();
    }
}
