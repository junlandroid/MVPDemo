package com.zhg.junl.biz;

import com.zhg.junl.entity.PersonBean;

/**
 * 当前类注释:登录请求结果回调
 */
public interface LoginRequestCallBack {
    // 登录请求成功的回调
    void loginSuccess(PersonBean personBean);
    //登录失败的回调
    void loginFailed();
}
