package com.gupaoedu.singleton.lazy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Author:KEVIN
 * Time:2019/3/10
 */
public class Outer {

    public Outer(){
        System.out.println("执行外部类构造方法");
    }

    static {
        System.out.println("执行外部类静态代码块");
    }

    public static void aaa (){
        System.out.println("执行外部类静态方法");
    }

    void bbb(){
        System.out.println("执行外部类普通方法");
    }

    //静态内部类
    static class StaticInner {

        public StaticInner(){
            System.out.println("执行内部类构造方法");
        }

        static {
            System.out.println("执行内部类静态代码块");
        }

        static void staticInnerMethod() {
            System.out.println("执行内部类静态方法");
        }


    }
    //当类第一次被加载的时候 会执行类的静态代码块会执行一次  后面不再执行

    public static void main(String[] args) throws NoSuchMethodException {
        Outer outer = new Outer();      //此刻其内部类是否也会被加载？
        System.out.println("===========分割线===========");
        Outer.StaticInner.staticInnerMethod();      //调用内部类的静态方法
//        Outer.aaa();
//        Outer.aaa();

//        Outer outer = new Outer();
//        outer.bbb();

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("aaa"));
            ois.readObject();
        }catch (Exception e){

        }

        Class clazz = LazySimpleSingleton.class;
        Constructor c = clazz.getDeclaredConstructor();
        try {
            c.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
