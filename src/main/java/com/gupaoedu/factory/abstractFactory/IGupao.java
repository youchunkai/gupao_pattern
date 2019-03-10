package com.gupaoedu.factory.abstractFactory;



/**
 * Author:KEVIN
 * Time:2019/3/7
 */
public interface IGupao {

    //???设计了一个案例  写着写着 又成了工厂方法了
    // 我的想法是  咕泡是个上层接口   工厂是:  咕泡西安  咕泡长沙  产品是:不同种类课程,活动 但不同地方要出现定制化东西
    //其实我是想 抽离一部分共有的东西 再生成一个接口,然后各个地方的咕泡都去实现共有部分,然后再定制一些 定制化的接口,不同地方的咕泡再去实现定制化的接口
    //算了 简单来
    ICourse createCourse();
    IActivity createActivity();
}
