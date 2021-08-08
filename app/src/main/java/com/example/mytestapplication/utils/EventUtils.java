package com.example.mytestapplication.utils;

import android.util.Log;
import android.view.MotionEvent;

public class EventUtils {


    public static void TouchEvent(MotionEvent event,String s){
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.i("jing",s+"    ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("jing",s+"    ACTION_MOVE");

                break;
            case MotionEvent.ACTION_UP:
                Log.i("jing",s+"    ACTION_UP");

                break;
        }


    }

}
