package com.example.yuan.choujiang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.RotateAnimation;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initView();
    }

    private void initView() {
        final DaView daView=findViewById(R.id.custom);
        findViewById(R.id.costom_inside).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              float degrees= (float) (720+Math.random() * 1000);
                RotateAnimation rotateAnimation=new RotateAnimation(0,-degrees,450,450);
                rotateAnimation.setDuration(5000);
                rotateAnimation.setFillAfter(true);
                daView.startAnimation(rotateAnimation);
            }
        });
    }
}
