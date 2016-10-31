package com.zhg.junl.ui.base;

import android.content.Intent;
import android.view.LayoutInflater;
import android.widget.Toast;

/**
 * 当前类注释:基类activity 主要封装一些工具类的使用，公共方法 配置
 * 项目名：
 * 作者：
 * 邮箱：15800904094@163.com
 * 公司：知惠馆
 */
public class BaseActivity extends BaseFragmActivity {

    /**
     * 获取当前view的LayoutInflater实例
     * @return
     */
    protected LayoutInflater getLayouInflater() {
        LayoutInflater _LayoutInflater = LayoutInflater.from(this);
        return _LayoutInflater;
    }

    /**
     * 弹出toast 显示时长short
     * @param pMsg
     */
    protected void showToastMsgShort(String pMsg) {
        Toast.makeText(this, pMsg, Toast.LENGTH_SHORT).show();
    }
    /**
     * 弹出toase 显示时长long
     * @param pMsg
     */
    protected void showToastMsgLong(String pMsg) {
        Toast.makeText(this, pMsg, Toast.LENGTH_LONG).show();
    }
    /**
     * 根据传入的类(class)打开指定的activity
     * @param pClass
     */
    protected void openActivity(Class<?> pClass) {
        Intent _Intent = new Intent();
        _Intent.setClass(this, pClass);
        startActivity(_Intent);
    }

    protected void openActivityByIntent(Intent pIntent){
        startActivity(pIntent);
    }



}
