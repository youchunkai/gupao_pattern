package com.gupaoedu.template.course;

/**
 * Author:KEVIN
 * Time:2019/3/20
 */
public class JavaCourse extends NetworkCourse {

    private boolean needHomeworkFlag = false;

    public JavaCourse() {
        this(false);
    }

    public JavaCourse(boolean needHomeworkFlag) {
        this.needHomeworkFlag = needHomeworkFlag;
    }


    @Override
    protected void checkHomeWork() {
        System.out.println("检查java作业");
    }

    @Override
    protected boolean needHomeWork() {
        return needHomeworkFlag;
    }
}
