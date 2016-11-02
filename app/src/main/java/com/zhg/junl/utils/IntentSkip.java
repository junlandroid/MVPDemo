package com.zhg.junl.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.zhg.junl.R;
import com.zhg.junl.application.JUNLApplication;

import java.io.File;

/**
 * 当前类注释：android常用的intent意图（未测试过）
 *
 */
public class IntentSkip
{
    // android获取一个用于打开HTML文件的intent
    private static Intent getHtmlFileIntent(File file)
    {
        Uri uri = Uri.parse(file.toString()).buildUpon().encodedAuthority("com.android.htmlfileprovider").scheme("content")
                .encodedPath(file.toString()).build();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(uri, "text/html");
        return intent;
    }

    // android获取一个用于打开图片文件的intent
    private static Intent getImageFileIntent(File file)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(file);
        intent.setDataAndType(uri, "image/*");
        return intent;
    }

    // android获取一个用于打开PDF文件的intent
    private static Intent getPdfFileIntent(File file)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(file);
        intent.setDataAndType(uri, "application/pdf");
        return intent;
    }

    // android获取一个用于打开文本文件的intent
    private static Intent getTextFileIntent(File file)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(file);
        intent.setDataAndType(uri, "text/plain");
        return intent;
    }

    // android获取一个用于打开音频文件的intent
    private static Intent getAudioFileIntent(File file)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("oneshot", 0);
        intent.putExtra("configchange", 0);
        Uri uri = Uri.fromFile(file);
        intent.setDataAndType(uri, "audio/*");
        return intent;
    }

    // android获取一个用于打开视频文件的intent
    private static Intent getVideoFileIntent(File file)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("oneshot", 0);
        intent.putExtra("configchange", 0);
        Uri uri = Uri.fromFile(file);
        intent.setDataAndType(uri, "video/*");
        return intent;
    }

    // android获取一个用于打开CHM文件的intent
    private static Intent getChmFileIntent(File file)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(file);
        intent.setDataAndType(uri, "application/x-chm");
        return intent;
    }

    // android获取一个用于打开Word文件的intent
    private static Intent getWordFileIntent(File file)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(file);
        intent.setDataAndType(uri, "application/msword");
        return intent;
    }

    // android获取一个用于打开Excel文件的intent
    private static Intent getExcelFileIntent(File file)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(file);
        intent.setDataAndType(uri, "application/vnd.ms-excel");
        return intent;
    }

    // android获取一个用于打开PPT文件的intent
    private static Intent getPPTFileIntent(File file)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(file);
        intent.setDataAndType(uri, "application/vnd.ms-powerpoint");
        return intent;
    }

    // android获取一个用于打开apk文件的intent
    private static Intent getApkFileIntent(File file)
    {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        return intent;
    }

    private static boolean checkEndsWithInStringArray(String checkItsEnd, String[] fileEndings)
    {
        for (String aEnd : fileEndings)
        {
            if (checkItsEnd.toLowerCase().endsWith(aEnd))
                return true;
        }
        return false;
    }

    public static Intent getSkipIntent(File currentPath)
    {
        Intent intent = null;
        Context context = JUNLApplication.getContext();

        String fileName = currentPath.toString();

        if (IntentSkip.checkEndsWithInStringArray(fileName, context.getResources().getStringArray(R.array.fileEndingImage)))
        {
            intent = IntentSkip.getImageFileIntent(currentPath);
        } else if (IntentSkip.checkEndsWithInStringArray(fileName,
                context.getResources().getStringArray(R.array.fileEndingWebText)))
        {
            intent = IntentSkip.getHtmlFileIntent(currentPath);
        } else if (IntentSkip.checkEndsWithInStringArray(fileName,
                context.getResources().getStringArray(R.array.fileEndingPackage)))
        {
            intent = IntentSkip.getApkFileIntent(currentPath);

        } else if (IntentSkip.checkEndsWithInStringArray(fileName,
                context.getResources().getStringArray(R.array.fileEndingAudio)))
        {
            intent = IntentSkip.getAudioFileIntent(currentPath);
        } else if (IntentSkip.checkEndsWithInStringArray(fileName,
                context.getResources().getStringArray(R.array.fileEndingVideo)))
        {
            intent = IntentSkip.getVideoFileIntent(currentPath);
        } else if (IntentSkip.checkEndsWithInStringArray(fileName,
                context.getResources().getStringArray(R.array.fileEndingText)))
        {
            intent = IntentSkip.getTextFileIntent(currentPath);
        } else if (IntentSkip.checkEndsWithInStringArray(fileName,
                context.getResources().getStringArray(R.array.fileEndingPdf)))
        {
            intent = IntentSkip.getPdfFileIntent(currentPath);
        } else if (IntentSkip.checkEndsWithInStringArray(fileName,
                context.getResources().getStringArray(R.array.fileEndingWord)))
        {
            intent = IntentSkip.getWordFileIntent(currentPath);
        } else if (IntentSkip.checkEndsWithInStringArray(fileName,
                context.getResources().getStringArray(R.array.fileEndingExcel)))
        {
            intent = IntentSkip.getExcelFileIntent(currentPath);
        } else if (IntentSkip.checkEndsWithInStringArray(fileName,
                context.getResources().getStringArray(R.array.fileEndingPPT)))
        {
            intent = IntentSkip.getPPTFileIntent(currentPath);
        }

        return intent;
    }
}
