package com.example.mytestapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ScrollViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);
        LinearLayout l = findViewById(R.id.linear1);
        for (int i = 0; i < l.getChildCount(); i++) {
            TextView t = (TextView) l.getChildAt(i);
            t.setTag("woshi "+i);
            t.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String s = (String) v.getTag();
                    Toast.makeText(ScrollViewActivity.this,s,Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}