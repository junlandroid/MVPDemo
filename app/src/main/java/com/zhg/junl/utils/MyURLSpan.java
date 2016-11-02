package com.zhg.junl.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.provider.Browser;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

import com.zhg.junl.application.JUNLApplication;

/**
 * 自定的URLSpan可以设置字体颜色下划线等样式，单击和双击的事件（未测试过）
 * [如：在TextView控件中单击链接弹出Activity]
 * 
 */
@SuppressLint("NewApi")
public class MyURLSpan extends ClickableSpan implements ParcelableSpan
{

    private final String mURL;

    public MyURLSpan(String url)
    {
        mURL = url;
    }

    @Override
    public int getSpanTypeId()
    {
        return 11;
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(mURL);
    }

    public String getURL()
    {
        return mURL;
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.text.style.ClickableSpan#onClick(android.view.View)
     */
    @Override
    public void onClick(View widget)
    {

        Uri uri = Uri.parse(getURL());
        Context context = widget.getContext();
        if (null != uri)
        {
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.putExtra(Browser.EXTRA_APPLICATION_ID, context.getPackageName());
            context.startActivity(intent);
        }
    }

    /**
     * 长按
     */
    public void onLongClick(View widget)
    {
        // 如果textview已经设置了长按事件所以有效
        widget.performLongClick();
    }

    @Override
    public void updateDrawState(TextPaint tp)
    {
        tp.setColor(JUNLApplication.getContext().getResources().getColor(android.R.color.black));
        tp.setUnderlineText(true); // 去掉下划线

    }
}
