package com.gupaoedu.template.course;

/**
 * Author:KEVIN
 * Time:2019/3/20
 */
public class BigDataCourse extends NetworkCourse {

    private boolean needHomeworkFlag = false;

    public BigDataCourse() {
        this(false);
    }

    public BigDataCourse(boolean needHomeworkFlag) {
        this.needHomeworkFlag = needHomeworkFlag;
    }


    @Override
    protected void checkHomeWork() {
        System.out.println("检查大数据作业");
    }

    @Override
    protected boolean needHomeWork() {
        return needHomeworkFlag;
    }
}
