package com.zhg.junl.presenter;

import android.os.Handler;

import com.zhg.junl.biz.IPersonBiz;
import com.zhg.junl.biz.LoginRequestCallBack;
import com.zhg.junl.biz.imp.PersonBizImp;
import com.zhg.junl.entity.PersonBean;
import com.zhg.junl.ui.view.ILoginView;

/**
 * 当前类注释:负责完成登录界面View与Model(IPersonBiz)间的交互
 * <p/>
 * Presenter层，作为Model和View之间交互的桥梁，在本例中执行登陆操作，然后去Model业务中执行登陆操作，
 * 然后将登陆结果信息返回给View层
 */
public class LoginPresenter {
    private static final String TAG = "LoginPresenter";
    private ILoginView mLoginView;
    private IPersonBiz mPersonBiz;

    private Handler mHandler = new Handler();

    /**
     * 构造方法中初始化Model实例IPersonBiz，用来调用登陆的方法
     * @param view
     */
    public LoginPresenter(ILoginView view) {
        mLoginView = view;
        mPersonBiz = new PersonBizImp();
    }

    public void loginSystem() {
        mPersonBiz.login(mLoginView.getUserName(), mLoginView.getPassword(), new LoginRequestCallBack() {

            /**
             * 用户业务逻辑实现类方法
             * 登陆成功的回调方法
             * @param personBean
             */
            @Override
            public void loginSuccess(final PersonBean personBean) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        //登陆结果返回给View层
                        mLoginView.showSuccessInfo(personBean);
                    }
                });
            }


            /**
             * 用户业务逻辑实现类
             * 登陆失败回调的方法
             */
            @Override
            public void loginFailed() {
                /**
                 * 不使用handler时，直接mLoginView.showFailedInfo();会报以下错
                 * Can't create handler inside thread that has not called Looper.prepare()
                 * 第一印象就是去Loop.prepare(),后来发现，其实这还是因为在线程中更新UI导致的，
                 * http://blog.csdn.net/jason0539/article/details/21196485
                 */
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mLoginView.showFailedInfo();
                    }
                });
            }
        });
    }
}
