package com.example.mytestapplication.app;

import android.content.Context;
import android.os.Environment;

import androidx.annotation.NonNull;
//异常处理见安卓开发艺术探索
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private static final String TAG = "CrashHandler";
    private static final boolean DEBUG = true;
    //异常存储位置
    private static final String PATH = Environment.getExternalStorageDirectory().getPath() + "/CrashTest/log/";

    private static final String FILE_NAME = "crash";
    private static final String FILE_NAME_SUFFIX = ".trace";
    private static CrashHandler sInstance = new CrashHandler();
    private Thread.UncaughtExceptionHandler mDefaultCrashHandler;
    private Context mContext;

    @Override
    public void uncaughtException(@NonNull Thread t, @NonNull Throwable e) {


    }
}
