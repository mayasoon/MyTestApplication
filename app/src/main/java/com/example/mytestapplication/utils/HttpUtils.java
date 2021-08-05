package com.example.mytestapplication.utils;

import android.app.ApplicationErrorReport;
import android.os.Handler;
import android.os.Looper;

public class HttpUtils {
    //在子线程中得到主线程的handler对象 并发送更新UI的消息
    Handler handler = new Handler(Looper.myLooper());


}
