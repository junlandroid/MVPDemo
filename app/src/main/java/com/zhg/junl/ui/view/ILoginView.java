package com.zhg.junl.ui.view;

import com.zhg.junl.entity.PersonBean;

/**
 * 当前类注释:登录页面 相关操作 功能接口
 */
public interface ILoginView {

    String getUserName();
    String getPassword();
    void showSuccessInfo(PersonBean personBean);
    void showFailedInfo();
}
