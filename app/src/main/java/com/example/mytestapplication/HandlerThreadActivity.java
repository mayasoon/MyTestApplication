package com.example.mytestapplication;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mytestapplication.bean.User;
import com.example.mytestapplication.utils.Constant;

import java.util.concurrent.TimeUnit;

public class HandlerThreadActivity extends AppCompatActivity {

    Handler handler = new Handler(msg -> {
        if (msg.what==1){
            ((TextView)findViewById(R.id.text1)).setText((String)msg.obj);

        }else if (msg.what==2){
            ((TextView)findViewById(R.id.text2)).setText((String)msg.obj);
        }
        return false;
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_thread);
        //Looper 当中有静态ThreadLocal  key所以每次获取的都是本线程的Looper对象
        Looper.getMainLooper();
        HandlerThread handlerThread = new HandlerThread("my");
        handlerThread.start();
        Handler localHandler = new Handler(handlerThread.getLooper());

        findViewById(R.id.button).setOnClickListener(v -> {
            localHandler.post(new MyRun(1));
            localHandler.post(new MyRun(2));
        });
        //加入延迟消息，更优雅的，提高启动速度。
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            @Override
            public boolean queueIdle() {
                return false;
            }
        });
        Message m = new Message();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            m.setAsynchronous(true);
        }
        //存入全局变量信息主线程当中,
        Constant.globalThreadLocal.set(new User(20,"小明"));
        //跳转
        findViewById(R.id.tiao).setOnClickListener(v -> HandlerThreadActivity.this.startActivity(new Intent(HandlerThreadActivity.this,MainActivity.class)));
    }

    class MyRun implements Runnable{
        private final int flag;

        public MyRun(int flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
            //模拟加载任务
            Message m = Message.obtain();
            m.what = flag;
            m.obj = flag +" 加载中...";
            handler.sendMessage(m);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Message m2 = Message.obtain();
            m2.what = flag;
            m2.obj = flag +"完成加载";
            handler.sendMessage(m2);
        }
    }

}