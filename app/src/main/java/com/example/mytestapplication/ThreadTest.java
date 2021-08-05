package com.example.mytestapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.audiofx.AutomaticGainControl;
import android.os.Bundle;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Lock lock = new ReentrantLock();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("111111");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("2222222");
    }
}