package com.example.yuan.pubu2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class WeekTitleViewGroup extends LinearLayout {
    Context mContext;
    public WeekTitleViewGroup(Context context) {
        super(context);
        context=mContext;
    }

    public WeekTitleViewGroup(Context context,AttributeSet attrs) {
        super(context, attrs);
        context=mContext;
        init();
    }

    private void init() {
        View view=View.inflate(mContext,R.layout.title,null);
    }
}
