package com.zhg.junl.test;

import android.os.Bundle;

import com.zhg.junl.R;
import com.zhg.junl.entity.PersonBean;
import com.zhg.junl.ui.base.BaseActivity;
import com.zhg.junl.ui.view.ILoginView;

/**
 * Created by Administrator on 2016/10/31 0031.
 */
public class MVPTestActiviy extends BaseActivity implements ILoginView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mvp_test_layout);
    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void showSuccessInfo(PersonBean personBean) {

    }

    @Override
    public void showFailedInfo() {

    }
}
