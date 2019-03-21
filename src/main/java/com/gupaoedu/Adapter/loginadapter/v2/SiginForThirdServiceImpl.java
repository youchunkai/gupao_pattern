package com.gupaoedu.Adapter.loginadapter.v2;

import com.gupaoedu.Adapter.loginadapter.v1.ResultMsg;

/**
 * Author:KEVIN
 * Time:2019/3/21
 */
public class SiginForThirdServiceImpl implements ISiginForThirdService {
    @Override
    public ResultMsg loginForQQ(String id) {
        return processLogin(id, LoginForQQAdapter.class);
    }

    private ResultMsg processLogin(String id, Class<LoginForQQAdapter> loginForQQAdapterClass) {
        try {
            LoginAdapter adapter = (LoginAdapter) loginForQQAdapterClass.newInstance();
            if (adapter.support(adapter)) {
                adapter.login(id, adapter);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
