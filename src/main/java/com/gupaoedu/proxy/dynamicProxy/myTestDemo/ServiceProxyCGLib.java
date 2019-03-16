package com.gupaoedu.proxy.dynamicProxy.myTestDemo;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Author:KEVIN
 * Time:2019/3/15
 */
public class ServiceProxyCGLib implements MethodInterceptor {

    public Object getInstance(Class clazz){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();

    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        before();
        Object obj = methodProxy.invokeSuper(o, objects);
        after();
        return obj;

    }

    private void after() {
        System.out.println("调用后增强逻辑");
    }

    private void before() {
        System.out.println("调用前增强逻辑");
    }
}
