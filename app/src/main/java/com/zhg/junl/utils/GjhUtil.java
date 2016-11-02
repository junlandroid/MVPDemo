package com.zhg.junl.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GjhUtil {
	
	/** 
	 * 判断是否为平板 
	 *  
	 * @return 
	 */  
	public static boolean isPad(Context context) {  
	    WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);  
	    Display display = wm.getDefaultDisplay();  
	    // 屏幕宽度  
	    float screenWidth = display.getWidth();  
	    // 屏幕高度  
	    float screenHeight = display.getHeight();  
	    DisplayMetrics dm = new DisplayMetrics();  
	    display.getMetrics(dm);  
	    double x = Math.pow(dm.widthPixels / dm.xdpi, 2);  
	    double y = Math.pow(dm.heightPixels / dm.ydpi, 2);  
	    // 屏幕尺寸  
	    double screenInches = Math.sqrt(x + y);  
	    // 大于6尺寸则为Pad  
	    if (screenInches >= 6.0) {  
	        return true;  
	    }  
	    return false;  
	}
	
	public static  String formatDate(Date date)throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       return sdf.format(date);
   }
	
	public static  String formatDate1(Date date)throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       return sdf.format(date);
   }
	
	public static  String formatDate2(Date date)throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd HH:mm");
       return sdf.format(date);
   }
   
   public static Date parse(String strDate) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       return sdf.parse(strDate);
   }
	
   public static String createFileName(String userid)
   {
       StringBuilder fileName = new StringBuilder();
       String timeStamp = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
       fileName.append(timeStamp);
       fileName.append("_");
       fileName.append("M");
       fileName.append("_");
       fileName.append(userid);
       fileName.append(".jpg");
       return fileName.toString();
   }
   
	
}
