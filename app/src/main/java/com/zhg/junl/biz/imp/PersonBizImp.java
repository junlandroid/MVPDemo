package com.zhg.junl.biz.imp;

import com.zhg.junl.biz.IPersonBiz;
import com.zhg.junl.biz.LoginRequestCallBack;
import com.zhg.junl.entity.PersonBean;
import com.zhg.junl.utils.Log;

/**
 *  当前类注释:用户相关业务逻辑实现类
 */
public class PersonBizImp implements IPersonBiz{
    private static final String TAG = "PersonBizImp";
    @Override
    public void login(final String username, final String password, final LoginRequestCallBack valueCallBack) {
        Log.d(TAG,"username:"+username+",password:"+password);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 开始登录，这边应该进行请求服务器，进行数据验证
                if (username.equals("junl") && password.equals("123")){
                    valueCallBack.loginSuccess(new PersonBean(username,password));
                }else {
                    valueCallBack.loginFailed();
                }
            }
        }).start();
    }
}
