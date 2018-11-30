package com.example.yuan.zidingyi_view;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class RectangleView extends View {
    Paint mPaint;
    public RectangleView(Context context) {
        super(context);
        init();
    }

    public RectangleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    //画笔,颜色,大小设置
    private void init() {
        mPaint=new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(10);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(50,50,50,200,mPaint);
        canvas.drawLine(50,200,600,200,mPaint);
        canvas.drawRect(60,100,100,200,mPaint);
        canvas.drawRect(130,120,150,200,mPaint);
        canvas.drawRect(170,120,190,200,mPaint);
    }
}
