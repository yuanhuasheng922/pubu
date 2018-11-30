package com.example.yuan.text_choujiang;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class MaxCircle extends View {
        Paint mPain;
        RectF mReft;
        int degress=0;
        int textdegress=15;
    public MaxCircle(Context context) {
        super(context);
        init();
    }

    public MaxCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
       mPain =new Paint();
       mPain.setStrokeWidth(10);
       mPain.setStyle(Paint.Style.FILL);

       mReft=new RectF();
       mReft.top=100;
       mReft.bottom=600;
       mReft.left=100;
       mReft.right=600;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //外面大圆盘
        //定义文字
        String[] strings=new String[]{"一","二","三","四","五","六"};
        //定义颜色
        int[] colors=new int[]{Color.RED,Color.BLACK,Color.BLUE,Color.YELLOW,Color.WHITE,Color.GREEN,};
        for (int i=0;i<6;i++)
        {
            //设置颜色
            mPain.setColor(colors[i]);
            Path path=new Path();
            //设置文字大小
            mPain.setTextSize(25);
            //画圆
            canvas.drawArc(mReft,degress,60,true,mPain);
            path.addArc(mReft,textdegress,60);
            //写文字
            mPain.setColor(Color.BLACK);
            canvas.drawTextOnPath(strings[i],path,60,60,mPain);
            degress+=60;
            textdegress+=60;
        }

    }
}
