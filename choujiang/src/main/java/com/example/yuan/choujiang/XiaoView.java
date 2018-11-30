package com.example.yuan.choujiang;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class XiaoView extends View {

    Paint mPaint;
    RectF rectF;
    String mStr;

    public XiaoView(Context context) {
        super(context);
        init();
    }

    public XiaoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //自定义属性控件
        TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.DaView);
        mStr=typedArray.getString(R.styleable.DaView_text);

        init();
    }


    private void init() {
        mPaint=new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(10);
        mPaint.setTextSize(60);
        mPaint.setStyle(Paint.Style.FILL);

        rectF =new RectF();
        rectF.top=100;
        rectF.bottom=450;
        rectF.left=350;
        rectF.right=550;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置画笔颜色为黑色
        mPaint.setColor(Color.BLACK);
        //画出指针,同一二扇形,然后盖住后面补分来简单表示
        canvas.drawArc(rectF,60,60,true,mPaint);
        mPaint.setColor(Color.RED);
        //画一个红色 的圆形,就是中间的大按钮
        canvas.drawCircle(450,450,80,mPaint);
        mPaint.setColor(Color.BLACK);
        //添加按钮上的文字
        canvas.drawText(mStr,400,480,mPaint);
    }
}
