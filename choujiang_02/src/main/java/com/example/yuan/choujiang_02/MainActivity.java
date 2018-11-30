package com.example.yuan.choujiang_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
                float defress= (float) (720+Math.random()*1000);
                RotateAnimation animation=new RotateAnimation(0,-defress,450,450);
                animation.setDuration(5000);
                animation.setFillAfter(true);
                maxCircle.startAnimation(animation);
            }
        });

    }
}
