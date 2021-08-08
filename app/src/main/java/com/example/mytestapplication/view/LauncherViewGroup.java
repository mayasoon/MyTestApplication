package com.example.mytestapplication.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;

public class LauncherViewGroup extends ViewGroup {

    private final int width;//屏幕的宽度
    private int scrollX;
    private float downX;
    private float moveX;
    private float lastX;
    private final int touchSlop;//用户滑动的最小距离，大于这个距离才视为有效滑动
    private int leftLimit;
    private int rightLimit;
    private final Context mContext;
    private final Scroller mScroller;
    private final String TAG = "stay4it";

    public LauncherViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
        width = getResources().getDisplayMetrics().widthPixels;
        mScroller = new Scroller(mContext);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(mContext);
        touchSlop = viewConfiguration.getScaledTouchSlop();


    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            int x=mScroller.getCurrX();
            int y=mScroller.getCurrY();
            Log.d("jing","x  "+x);

            scrollTo(x, y);
            invalidate();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            measureChild(childView, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (changed) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childView = getChildAt(i);
                int left = i * childView.getMeasuredWidth();
                int top = 0;
                int right = (i + 1) * childView.getMeasuredWidth();
                int bottom = childView.getMeasuredHeight();
                childView.layout(left, top, right, bottom);
            }
            leftLimit = getChildAt(0).getLeft();
            rightLimit = getChildAt(childCount - 1).getRight();
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }
    float x = 0f;
    float y = 0f;
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercepted = false;
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x = ev.getX();
                y = ev.getY();
                downX = ev.getRawX();
                Log.w("jing"," onInterceptTouchEvent downX  "+downX);
                lastX = downX;
                intercepted = false;
                break;
            case MotionEvent.ACTION_MOVE://解决滑动冲突
                float mx = ev.getX();
                float my = ev.getY();
                //左右滑动需要这个事件，交由自身处理
                intercepted = Math.abs(mx - x) > Math.abs(my - y);
                x = mx;
                y = my;
                break;
            case MotionEvent.ACTION_UP:
                intercepted = false;
                break;
            default:
                break;
        }
        return intercepted;
    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = ev.getRawX();
                Log.i("jing","onTouchEvent  ACTION_DOWN downX  "+downX);

                break;
            case MotionEvent.ACTION_MOVE:
                moveX = ev.getRawX();
                Log.i("jing"," onTouchEvent ACTION_MOVE moveX  "+moveX);

                int moveDistanceX = (int) (lastX - moveX);
                scrollX = getScrollX();
                Log.i("jing","onTouchEvent ACTION_MOVE scrollX  "+scrollX + "    moveDistanceX   "  +moveDistanceX);

                if (scrollX + moveDistanceX < leftLimit) {
                    scrollTo(leftLimit, 0);
                    return true;
                }

                if (scrollX + moveDistanceX + width > rightLimit) {
                    scrollTo(rightLimit - width, 0);
                    return true;
                }
                scrollBy(moveDistanceX*2, 0);
                lastX = moveX;
                break;
            case MotionEvent.ACTION_UP:
                scrollX = getScrollX();
                Log.i("jing","ACTION_UP onTouchEvent scrollX  "+scrollX);
                int index = (scrollX + width / 2) / width;
                int distanceX = width * index - scrollX;
                mScroller.startScroll(scrollX, 0, distanceX, 0);
                invalidate();
                break;
        }
        return true;
    }

    @Override
    public void setOnTouchListener(OnTouchListener l) {
        super.setOnTouchListener(l);
    }

}
