package com.zhg.junl.utils;

import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;

public class GetMobileInfoUtil {

	public static int getScreenWidth(FragmentActivity context){
		DisplayMetrics metric = new DisplayMetrics();
		context.getWindowManager().getDefaultDisplay().getMetrics(metric);  
		int width = (int) ((metric.widthPixels)*0.8);     // 屏幕宽度（像素） 
		return width;
	}
	
}
