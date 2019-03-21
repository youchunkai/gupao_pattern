package com.gupaoedu.template.course;

/**
 * Author:KEVIN
 * Time:2019/3/20
 */
public abstract class NetworkCourse {

    //指定流程模板
    protected final void createCourse(){
        //1.发布预习资料
        publishPreResource();
        //2.制作ppt课件
        createPPT();
        //3.网上直播
        onlineLive();
        //4.提交课件 课堂笔记
        commitNote();
        //5.提交源码
        commitResource();
        //6.布置作业  有的课程没有作业没,就完成了
        if(needHomeWork()){
            checkHomeWork();
        }
    }

    protected abstract void checkHomeWork();

    protected abstract boolean needHomeWork();

    final void commitResource() {
        System.out.println("提交源码");
    }

    final void commitNote() {
        System.out.println("提交课程笔记");
    }

    final void onlineLive() {
        System.out.println("网上直播");
    }

    final void createPPT() {
        System.out.println("制作PPT");
    }

    final void publishPreResource(){
        System.out.println("发布预习资料");
    }
}
