package com.zhg.junl.biz;

/**
 * 当前类注释:用户相关业务操作接口
 */
public interface IPersonBiz {
    void login(String username,String password, LoginRequestCallBack valueCallBack);
}
