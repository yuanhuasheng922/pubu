package com.example.yuan.pubu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomWaterFallViewGroup extends LinearLayout {

    //每行最大允许字符串
    final int mMaxsize=22;
    //传入的字符串数组
    List<String> stringList=new ArrayList<>();
    //上下文

    Context mContext;

    public CustomWaterFallViewGroup(Context context) {
        super(context);
        mContext=context;
        init();
    }

    public CustomWaterFallViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
        init();
    }
    //设置最外层的线性布局为垂直布局
    private void init() {
        setOrientation(VERTICAL);
    }
    //直接用新的列表 重新绘制
    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
        showData();
    }

    private void showData() {
        //因为每一次都要重新画  所以移除以前所有的布局
        removeAllViews();
        //优先向根布局添加一条横线布局
        LinearLayout linearLayout= (LinearLayout) View.inflate(mContext,R.layout.item_water,null);
        addView(linearLayout);
        //定义临时变量 ,同来计算最后一行已有的字符串长度
        int len=0;
        //便利
        for (String str :stringList)
        {
            //将此字符串长度与记录的已有字符串长度相加
            len+=str.length();
            //如果长度大于规定的最大长度  说明这一行放不下了,需要换行
            if (len>mMaxsize)
            {
                //向根布局 添加一条横向布局
                 linearLayout= (LinearLayout) View.inflate(mContext,R.layout.item_water,null);
                addView(linearLayout);
                //因为换行 所以这一个字符串长度就是最后一行长度
                len=str.length();
            }
            //添加TextView  并赋值
            View view=View.inflate(mContext,R.layout.item_water_fall,null);
            TextView textView=view.findViewById(R.id.text);
            textView.setText(str);
            linearLayout.addView(view);

            //设置权重 让每一行内所有的控件相加充满整行 并进行合理的分配
            LinearLayout.LayoutParams layoutParams= (LayoutParams) view.getLayoutParams();
            layoutParams.weight=1;
        }
    }
}
