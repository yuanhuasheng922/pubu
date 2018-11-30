package com.example.yuan.choujiang_02;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class MinCircle extends View {
    //画笔
    Paint mPain;
    //角度
    RectF rectF;
    private String str;

    public MinCircle(Context context) {
        super(context);
        init();
    }


    public MinCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MaxCircle);
        str = typedArray.getString(R.styleable.MaxCircle_text);

        init();
    }

    private void init() {
        //画笔
        mPain = new Paint();
        //颜色
        mPain.setColor(Color.RED);
        mPain.setStrokeWidth(10);
        //文字大小
        mPain.setTextSize(60);
        //样式
        mPain.setStyle(Paint.Style.FILL);

        rectF = new RectF();
        rectF.top = 100;
        rectF.bottom=450;
        rectF.left=350;
        rectF.right=550;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPain.setColor(Color.YELLOW);
        //画出一个指针 用一个扇形 然后盖着后面部分来简单表示
        canvas.drawArc(rectF,60,60,true,mPain);
//        mPain.setColor(Color.YELLOW);
//        Path path=new Path();
//        path.moveTo(500,500);
//        path.lineTo(500,550);
//        path.lineTo(600,650);
//        path.close();
//        canvas.drawPath(path,mPain);
        mPain.setColor(Color.GREEN);
        //花一份红色的圆形  就是中间的大按钮
        canvas.drawCircle(450,450,100,mPain);
        mPain.setColor(Color.BLUE);
        //添加按钮上的文字
        canvas.drawText(str,380,480,mPain);

    }
}
