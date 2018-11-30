package com.example.yuan.choujiang_02;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class MaxCircle extends View {
    //画笔
    Paint mPain;
    //数量
    int mCount=6;
    //度数
    RectF rectF;
    //开始度数
    float mStartAngle=0;

    public MaxCircle(Context context) {
        super(context);
        init();
    }

    public MaxCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    //设置画笔
    private void init() {
        mPain=new Paint();
        //画笔颜色
        mPain.setColor(Color.BLUE);
        //画笔粗细
        mPain.setStrokeWidth(10);
        //字体大小
        mPain.setTextSize(60);
        //样式
        mPain.setStyle(Paint.Style.FILL);
        //设置度数
        rectF=new RectF();
        rectF.top=100;
        rectF.bottom=800;
        rectF.left=100;
        rectF.right=800;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i=0;i<mCount;i++)
        {
            if (i%2==0)
            {
                //按照角标单双号设置扇形颜色
                mPain.setColor(Color.BLACK);
            }
            else
            {
                mPain.setColor(Color.RED);
            }
            canvas.drawArc(rectF,mStartAngle,60,true,mPain);
            mStartAngle+=60;
        }

    }
}
