package com.example.yuan.textview;


import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class CustomRandomTextView extends android.support.v7.widget.AppCompatTextView {


    public CustomRandomTextView(Context context) {
        super(context);
        init();
    }

    public CustomRandomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    //点击事件
    private void init() {
       changeText();
       setOnClickListener(new OnClickListener() {
           @Override
           public void onClick(View v) {
               changeText();
           }
       });
    }
    int i=0;
    private void changeText() {
        //设置值
        setText(String.valueOf(getRandom()));
        //判断改变背景
        if (i%2==0)
        {
            setBackgroundColor(Color.GREEN);
        }
        else
        {
            setBackgroundColor(Color.YELLOW);
        }
        i++;
    }
    //设置随机数
    private int getRandom()
    {
        //获取随机数Math.random  取值范围  0 ,1
        //所有*9000后取值范围  0,9000
        //最后加上1000  范围  1000,10000
        return (int) (Math.random()*9000+1000);
    }
}
