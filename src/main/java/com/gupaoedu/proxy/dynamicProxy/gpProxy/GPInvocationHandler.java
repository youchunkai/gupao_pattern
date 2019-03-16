package com.gupaoedu.proxy.dynamicProxy.gpProxy;

import java.lang.reflect.Method;

/**
 * Author:KEVIN
 * Time:2019/3/16
 */
public interface GPInvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
