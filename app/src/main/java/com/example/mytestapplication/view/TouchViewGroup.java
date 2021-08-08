package com.example.mytestapplication.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.mytestapplication.utils.EventUtils;

public class TouchViewGroup extends LinearLayout {

    public TouchViewGroup(Context context) {
        super(context);
    }

    public TouchViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        EventUtils.TouchEvent(ev,"ViewGroup  onInterceptTouchEvent  1111");
        boolean s = super.onInterceptTouchEvent(ev);
        Log.w("jing","ViewGroup  onInterceptTouchEvent  2222    "+s);
        return s;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        EventUtils.TouchEvent(ev,"ViewGroup  dispatchTouchEvent  1111");
        boolean s = super.dispatchTouchEvent(ev);
        Log.w("jing","ViewGroup  dispatchTouchEvent  2222   "+s);
        return s;

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        EventUtils.TouchEvent(event,"ViewGroup  onTouchEvent  1111");
        boolean s = super.onTouchEvent(event);
        Log.w("jing","ViewGroup  onTouchEvent  2222     "+s);
        return s;

    }
}
