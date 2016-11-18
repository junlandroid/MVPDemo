package com.zhg.junl.application;

import android.app.Application;

import java.util.HashMap;
import java.util.Objects;

import de.greenrobot.dao.query.QueryBuilder;

/**
 * 当前类注释:自定义全局 application 主要进全局引用,行存储全局变量,全局配置/设置,初始化等相关工作
 */

public class JUNLApplication extends Application{

    private HashMap<String,Objects> mTemp=new HashMap<String,Objects>();
    private static JUNLApplication instance;
    private static JUNLApplication context;

    public  static JUNLApplication getInstance(){
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        this.instance=this;

        context = this;
        //初始化崩溃日志收集器
//        CustomCrash mCustomCrash=CustomCrash.getInstance();
        //mCustomCrash.setCustomCrashInfo(this);

        //greenDao相关操作
        QueryBuilder.LOG_SQL = true;
        QueryBuilder.LOG_VALUES = true;

    }

    public static JUNLApplication getContext(){
        return context;
    }




}
