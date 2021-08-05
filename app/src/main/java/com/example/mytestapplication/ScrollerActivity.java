package com.example.mytestapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.mytestapplication.databinding.ActivityScrollerBinding;

public class ScrollerActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityScrollerBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_scroller);

        binding.scrollerTo.setOnClickListener(this);
        binding.scrollBy.setOnClickListener(this);
        binding.reset.setOnClickListener(this);
        binding.start.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.scroll_by){
            binding.textView.scrollBy(30,0);
            float scrollX = binding.textView.getScrollX();
            float scrollY = binding.textView.getScrollY();
            Log.i("jing"," X "+scrollX + " Y "+scrollY);

        }else if (v.getId()==R.id.scroller_to){
            binding.textView.scrollTo(-200,0);
        }else if (v.getId()==R.id.reset){
            binding.textView.scrollTo(0,0);
        }else if (v.getId()==R.id.start){
            binding.linear.beginScroll();
        }
    }
}