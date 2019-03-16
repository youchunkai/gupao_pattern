package com.gupaoedu.proxy.dynamicProxy.myTestDemo;

import net.sf.cglib.core.DebuggingClassWriter;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * Author:KEVIN
 * Time:2019/3/14
 */
public class DynamicProxyTest2 {

    public static void main(String[] args) {

        //这是个为了用而用的案例
        //会发现 对已经存在了的service 进行日志监控,用代理的方法显然不是很理想的,
        // 并不是每个service都实现了接口,且实体类的方法 并不是全都是重写后的方法
        IServiceLogger userService = (IServiceLogger)new ServiceLoggerProxy().getInstance(new UserService());

        userService.methodA();
        userService.methodB();
        userService.methodC();

        ProxyGenerator.generateProxyClass("$proxy1",new Class[]{IServiceLogger.class});

        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{IServiceLogger.class});
        try{
            String filePath = DynamicProxyTest2.class.getResource("").getPath();
            System.out.println(filePath);
            FileOutputStream os = new FileOutputStream(filePath+"$Proxy0.class");
            os.write(bytes);
            os.close();
        }catch (Exception e){
            e.printStackTrace();
        }


        System.out.println("=========================================");
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "d://cglib_proxy_classes");

        UserService userService1 = (UserService)new ServiceProxyCGLib().getInstance(UserService.class);
        userService1.methodC();
        userService1.methodB();
        userService1.methodA();



    }
}
