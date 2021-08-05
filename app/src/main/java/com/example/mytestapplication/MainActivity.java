package com.example.mytestapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.IntentService;
import android.graphics.Bitmap;
import android.media.audiofx.LoudnessEnhancer;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.util.Log;
import android.util.LruCache;

import com.example.mytestapplication.bean.User;
import com.example.mytestapplication.utils.Constant;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class MainActivity extends AppCompatActivity {

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {


            return false;
        }
    });

    Handler h2 = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {


            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        String s = "2";
//        Handler handler = new Handler(new Handler.Callback() {
//            @Override
//            public boolean handleMessage(@NonNull Message msg) {
//                return false;
//            }
//        });
//
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        },1000);
//        Message message = Message.obtain(handler);
//        message.setTarget(handler);
//        HandlerThread handlerThread = new HandlerThread("A-Thread");
//        handler.sendMessage(message);
//        handler.post(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
//
//        Handler h = new Handler(handlerThread.getLooper());
//        handlerThread.start();
//        ThreadLocal threadLocal = new ThreadLocal();
//        threadLocal.set(null);
//        threadLocal.get();
//        HashMap map = new HashMap();
//        map.put("","");
//
//        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
//            @Override
//            public boolean queueIdle() {
//
//                return false;
//            }
//        });

        //这里取出在主线程 ThreadLocalMap 当中的全局变量信息请求持有
        User u = Constant.globalThreadLocal.get();
        Log.i("jing",u.name +" 今年 "+u.age+"岁");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                Looper.loop();


            }
        });
        handler.sendMessage(Message.obtain());
//        IntentService
        int max = (int) Runtime.getRuntime().maxMemory();
        int cacheSize = max/8;
        LruCache<String, Bitmap> lruCache = new LruCache<String, Bitmap>(max){
            @Override
            protected int sizeOf(String key, Bitmap value) {

                return super.sizeOf(key, value);
            }
        };


    }
}