package com.gupaoedu.proxy.dynamicProxy.gpProxy;

import net.sf.cglib.proxy.Proxy;

import java.lang.reflect.Method;

/**
 * Author:KEVIN
 * Time:2019/3/16
 */
public class GPMeipo implements GPInvocationHandler {


    Object targer;

    public Object getProxyInstance(Object targer){
        this.targer = targer;
        Class clazz = targer.getClass();
//        Object o = Proxy.newProxyInstance(clz.getClassLoader(), clz.getInterfaces(), this);
        Object obj = GPProxy.newProxyInstance(new GPClassLoader(), clazz.getInterfaces(), this);
        return obj;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        before();
        Object object = method.invoke(targer, args);
        after();
        return null;
    }


    public void before(){
        System.out.println("执行前逻辑");
    }

    public void after(){
        System.out.println("执行后逻辑");
    }
}
