package com.zhg.junl.presenter;

import com.zhg.junl.biz.IPersonBiz;
import com.zhg.junl.biz.LoginRequestCallBack;
import com.zhg.junl.biz.imp.PersonBizImp;
import com.zhg.junl.entity.PersonBean;
import com.zhg.junl.ui.view.ILoginView;

import java.util.logging.Handler;

/**
 * 当前类注释:负责完成登录界面View与Model(IPersonBiz)间的交互
 */
public class LoginPresenter {
    private static final String TAG ="LoginPresenter";
    private ILoginView mLoginView;
    private IPersonBiz mPersonBiz;

//    private Handler mHandler=new Handler();

    public LoginPresenter(ILoginView view){
        mLoginView = view;
        mPersonBiz = new PersonBizImp();
    }

    public void loginSystem(){
        mPersonBiz.login(mLoginView.getUserName(), mLoginView.getPassword(), new LoginRequestCallBack() {
            @Override
            public void loginSuccess(PersonBean personBean) {

            }

            @Override
            public void loginFailed() {

            }
        });
    }
}
