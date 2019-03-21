package com.gupaoedu.Adapter.loginadapter.v2;

import com.gupaoedu.Adapter.loginadapter.v1.ResultMsg;

/**
 * Author:KEVIN
 * Time:2019/3/21
 */
public class LoginForQQAdapter implements LoginAdapter {
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForQQAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adaper) {
        return null;
    }
}
