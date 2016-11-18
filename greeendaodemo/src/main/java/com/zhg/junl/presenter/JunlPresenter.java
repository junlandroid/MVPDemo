package com.zhg.junl.presenter;

import android.content.Context;

import com.zhg.junl.db.dao.DaoMaster;
import com.zhg.junl.db.dao.DaoSession;

/**
 * Created by Administrator on 2016/11/18.
 */
public class JunlPresenter {
    public static final String dbName = "mynote.db";
    DaoSession daoSession;
    DaoMaster daoMaster;
    DaoMaster.DevOpenHelper helper;

    public JunlPresenter(Context context){
//        helper = new DaoMaster.OpenHelper(context,dbName,null);
    }

}
