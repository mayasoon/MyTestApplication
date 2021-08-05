package com.example.mytestapplication.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Scroller;

import org.xmlpull.v1.XmlPullParser;

//自定义view实现滚动效果
public class LinearLayoutSubClass extends LinearLayout {

    private Scroller scroller;
    private boolean flag = true;
    private int offsetY;
    private int offsetX;
    private int duration;//持续时间

    public LinearLayoutSubClass(Context context) {
        this(context,null);
    }

    public LinearLayoutSubClass(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LinearLayoutSubClass(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        scroller = new Scroller(context);
        duration = 10000;


    }

    @Override
    public void computeScroll() {
        if (scroller.computeScrollOffset()){
            scrollTo(scroller.getCurrX(),scroller.getCurrY());
            invalidate();
        }

    }

    public void beginScroll() {
        if (flag) {
            offsetY = -100;
            int startX = -300;
            int startY = -90;
            int dx = -500;
            int dy = 0;
            scroller.startScroll(startX, startY, dx, dy, duration);
            flag = false;
        } else {
            offsetY = 0;
            int startX = scroller.getCurrX();
            int startY = scroller.getCurrX();
            int dx = -startX;
            int dy = 0;
            scroller.startScroll(startX, startY, dx, dy, duration);
            flag = true;
        }
        invalidate();
    }
}
