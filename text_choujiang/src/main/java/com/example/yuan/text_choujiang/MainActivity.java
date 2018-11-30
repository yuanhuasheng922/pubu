package com.example.yuan.text_choujiang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

public class MainActivity extends AppCompatActivity {

    private MaxCircle maxCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maxCircle = findViewById(R.id.max);
        findViewById(R.id.min).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               float degress= (float) (720+Math.random()*1000);
                RotateAnimation rotateAnimation=new RotateAnimation(0,degress,350,350);
                rotateAnimation.setFillAfter(true);
                rotateAnimation.setDuration(5000);
                maxCircle.startAnimation(rotateAnimation);
            }
        });

    }
}
