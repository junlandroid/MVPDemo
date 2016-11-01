package com.zhg.junl.test;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.zhg.junl.R;
import com.zhg.junl.entity.PersonBean;
import com.zhg.junl.presenter.LoginPresenter;
import com.zhg.junl.ui.base.BaseActivity;
import com.zhg.junl.ui.view.ILoginView;

/**
 * Created by Administrator on 2016/10/31 0031.
 */
public class MVPTestActiviy extends BaseActivity implements ILoginView {

    private LoginPresenter mLoginPresenter;
    private EditText ed_username;
    private EditText ed_password;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mvp_test_layout);

        ed_username=(EditText)this.findViewById(R.id.ed_username);
        ed_password=(EditText)this.findViewById(R.id.ed_password);
        btn_login=(Button)this.findViewById(R.id.btn_login);

        /**
         *  初始化LoginPresenter
         *  this指代是ILoginView，在LoginPresenter的构造方法中，将该接口传递进去
         *
         */
        mLoginPresenter = new LoginPresenter(this);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginPresenter.loginSystem();
            }
        });
    }

    /**
     * 返回用户名信息
     * @return
     */
    @Override
    public String getUserName() {
        return ed_username.getText().toString().trim();
    }

    /**
     * 返回用户密码信息
     * @return
     */
    @Override
    public String getPassword() {
        return ed_password.getText().toString().trim();
    }

    /**
     * 登陆成功的回调
     * @param personBean
     */
    @Override
    public void showSuccessInfo(PersonBean personBean) {
        showToastMsgLong("登陆成功："+personBean.toString());
    }

    /**
     * 登陆失败的回调
     */
    @Override
    public void showFailedInfo() {
        showToastMsgShort("登陆失败");
    }
}
