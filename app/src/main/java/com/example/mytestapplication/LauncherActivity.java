package com.example.mytestapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.mytestapplication.view.LauncherViewGroup;
import com.example.mytestapplication.view.MyImageView;

public class LauncherActivity extends AppCompatActivity {

    LauncherViewGroup viewGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        viewGroup = (LauncherViewGroup) ((ViewGroup) getWindow().getDecorView().findViewById(android.R.id.content)).getChildAt(0);
        Log.i("jing","子view  "+viewGroup.getChildCount());



    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("jing","Activity dispatchTouchEvent 111");
        boolean s = super.dispatchTouchEvent(ev);
        Log.d("jing","Activity dispatchTouchEvent 222");
        return s;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("jing","Activity onTouchEvent 111");
        boolean s = super.onTouchEvent(event);
        Log.d("jing","Activity onTouchEvent 111");
        return s;
    }

    @Override
    public void setFinishOnTouchOutside(boolean finish) {
        super.setFinishOnTouchOutside(finish);
    }
}