package com.example.yuan.choujiang;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class DaView extends View {
    Paint mPaint;
    int mCircleCount=6;
    float mStartAngle = 0;

    RectF rectF;
    public DaView(Context context) {
        super(context);
        init();
    }

    public DaView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        //初始化画笔
        mPaint=new Paint();
        //设置画笔颜色
        mPaint.setColor(Color.BLUE);
        //设置画笔宽度
        mPaint.setStrokeWidth(10);
        //设置文字大小
        mPaint.setTextSize(60);
        mPaint.setStyle(Paint.Style.FILL);

        rectF =new RectF();
        rectF.top=100;
        rectF.left=100;
        rectF.right=800;
        rectF.bottom=800;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i=0; i <mCircleCount; i++)
        {
            //按找角标单双号设置扇形颜色
            if (i%2==0)
            {
                mPaint.setColor(Color.GRAY);
            }
            else
            {
                mPaint.setColor(Color.BLUE);
            }
            canvas.drawArc(rectF,mStartAngle,60,true,mPaint);
            mStartAngle +=60;
        }

    }
}
