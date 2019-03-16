package com.gupaoedu.proxy.dynamicProxy.JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Author:KEVIN
 * Time:2019/3/14
 */
public class DynamicProxy implements InvocationHandler {


    Person target;


    public Object getInstance(Person target){
        /*
        * getInstance 是为了获得一个动态代理类,然后调用动态代理类的 invoke的方法
        * */
        this.target = target;
        Class clazz = target.getClass();
        //newProxyInstance  用什么 类加载器去加载   这个类都要实现哪些接口 ,调用那个处理器的 invoke 方法
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj = method.invoke(this.target,args);
        after();
        return obj;
    }

    private void after() {
        System.out.println("找工作之后");
    }

    private void before() {
        System.out.println("找工作之前");
    }
}
