package com.gupaoedu.proxy.dynamicProxy.myTestDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Author:KEVIN
 * Time:2019/3/14
 */
public class ServiceLoggerProxy implements InvocationHandler {


    UserService userService;

    public Object getInstance(UserService userService){
        this.userService = userService;
        Class clazz = userService.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        beforeLogger();
        Object object = method.invoke(userService, args);
        afterLogger();
        return null;

    }

    private void afterLogger() {
        System.out.println("执行后逻辑");
    }

    private void beforeLogger() {
        System.out.println("执行前逻辑");
    }
}
