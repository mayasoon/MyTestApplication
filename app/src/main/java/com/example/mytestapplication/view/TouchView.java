package com.example.mytestapplication.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.mytestapplication.utils.EventUtils;

public class TouchView extends View {
    public TouchView(Context context) {
        super(context);
    }

    public TouchView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        EventUtils.TouchEvent(event,"ViewGroup  onTouchEvent  1111");
        boolean s = super.onTouchEvent(event);
        Log.w("jing","View  onTouchEvent 2222   "+s);
        return s;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        EventUtils.TouchEvent(event,"ViewGroup  dispatchTouchEvent  1111");

        boolean s = super.dispatchTouchEvent(event);
        Log.w("jing","View  dispatchTouchEvent 2222     "+s);
        return s;

    }
}
