package com.zhg.junl.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

/**
 *  当前类注释:进度条提示框
 */
public class ProgressDlgUtil {  
    static ProgressDialog progressDlg = null;  
  
    /** 
     * 启动进度条 
     *  
     * @param strMessage 
     *            进度条显示的信息 
     * @param activity 
     *            当前的activity 
     */  
    public static void showProgressDlg(String strMessage, Context ctx) {  
  
        if (null == progressDlg) {  
            progressDlg = new ProgressDialog(ctx);  
            //设置进度条样式  
            progressDlg.setProgressStyle(ProgressDialog.STYLE_SPINNER);  
            //设置进度条标题  
//            progressDlg.setTitle(ctx.getString(R.string.app_name));  
            //提示的消息  
            progressDlg.setMessage(strMessage);  
            progressDlg.setIndeterminate(false);  
            progressDlg.setCancelable(false);  
//            progressDlg.setIcon(R.drawable.ic_launcher_scale);  
            progressDlg.show();  
        }  
        
        progressDlg.setOnKeyListener(onKeyListener);
    }  
  
    /** 
     * 结束进度条 
     */  
    public static void stopProgressDlg() {  
        if (null != progressDlg) {  
            progressDlg.dismiss();  
            progressDlg = null;  
        }  
    }
    
    /**
     * add a keylistener for progress dialog
     */
    private static OnKeyListener onKeyListener = new OnKeyListener() {
        @Override
        public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            	stopProgressDlg();
            }
            return false;
        }
    };

    
}  
