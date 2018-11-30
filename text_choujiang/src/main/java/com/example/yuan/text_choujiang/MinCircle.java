package com.example.yuan.text_choujiang;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

public class MinCircle extends View {
    Paint mPaint;
    RectF mRectf;

    public MinCircle(Context context) {
        super(context);

    }

    public MinCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //自定义宽高
        setMeasuredDimension(120,150);
    }

    private void init() {
        mPaint=new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(10);
        mPaint.setTextSize(20);
        mPaint.setStyle(Paint.Style.FILL);

        mRectf=new RectF();
        mRectf.top=100;
        mRectf.bottom=300;
        mRectf.left=350;
        mRectf.right=450;
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.BLACK);
       canvas.drawArc(0,-120,120,120,60,60,true,mPaint);
        mPaint.setColor(Color.RED);
        canvas.drawCircle(60,90,60,mPaint);
        mPaint.setColor(Color.BLACK);
       canvas.drawText("start",30,100,mPaint);


    }
}
