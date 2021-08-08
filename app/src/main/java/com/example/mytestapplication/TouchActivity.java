package com.example.mytestapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mytestapplication.utils.EventUtils;
import com.example.mytestapplication.view.TouchView;

public class TouchActivity extends Activity {
    Handler handler = new Handler();
    TouchView touchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);
        ViewGroup group = findViewById(android.R.id.content);//得到FrameLayout;
        LinearLayout l = (LinearLayout) group.getChildAt(0);//所设置的contentView

        touchView = l.findViewById(R.id.touch_view);
    }

    //返回true或者false消费掉事件不再往下传递事件，就是不调用super方法，super方法最终会指向自身所设置的setContentView ---> ViewGroup里的dispatchTouchEvent
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        EventUtils.TouchEvent(ev," Activity dispatchTouchEvent");
        boolean s = super.dispatchTouchEvent(ev);
        Log.w("jing","Activity dispatchTouchEvent  2222  " +s );
        return s;
    }

    @Override
    public void onUserInteraction() {
        Log.d("jing","Activity  onUserInteraction");

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        EventUtils.TouchEvent(event," Activity onTouchEvent");
        boolean s = super.onTouchEvent(event);
        Log.w("jing","Activity onTouchEvent  2222   " +s);
        return s;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }

    private void getViewWandH(){
        handler.post(new Runnable() {
            @Override
            public void run() {
                int width = touchView.getMeasuredWidth();
                int height = touchView.getMeasuredHeight();
            }
        });
    }

}