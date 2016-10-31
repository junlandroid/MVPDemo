package com.zhg.junl.ui.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.zhg.junl.utils.Log;
import com.zhg.junl.utils.ManagerActivity;

/**
 * 当前类注释:Activity框架封装类
 */
public class BaseFragmActivity  extends Activity {

    private static final String TAG = "lifecycles";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Log.d(TAG,"BaseActivity onCreate Invoke...");
        ManagerActivity.getInstance().addActivity(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"BaseActivity onStart Invoke...");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "BaseActivity onRestart Invoke...");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "BaseActivity onResume Invoke...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "BaseActivity onPause Invoke...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "BaseActivity onStop Invoke...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "BaseActivity onDestroy Invoke...");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.d(TAG, "BaseActivity onLowMemory Invoke...");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.d(TAG, "BaseActivity onBackPressed Invoke...");
        ManagerActivity.getInstance().removeActivity(this);
    }
}
