package com.gupaoedu.Adapter.loginadapter.v2;

import com.gupaoedu.Adapter.loginadapter.v1.ResultMsg;

/**
 * Author:KEVIN
 * Time:2019/3/21
 */
public interface LoginAdapter {

    boolean support(Object adapter);

    ResultMsg login(String id, Object adaper);


}
