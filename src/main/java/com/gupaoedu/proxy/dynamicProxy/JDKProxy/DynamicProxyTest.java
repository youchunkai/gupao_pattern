package com.gupaoedu.proxy.dynamicProxy.JDKProxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Author:KEVIN
 * Time:2019/3/14
 */
public class DynamicProxyTest {

    public static void main(String[] args) throws IOException {
        Person worker = (Person) new DynamicProxy().getInstance(new Worker());
        worker.findJob();
        byte[] bytes = ProxyGenerator.generateProxyClass("$proxy2", new Class[]{Person.class});
        FileOutputStream os = new FileOutputStream("D:/Proxy2.class");
        os.write(bytes);
        os.close();

    }
}
