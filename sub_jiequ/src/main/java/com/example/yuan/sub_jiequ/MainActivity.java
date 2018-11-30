package com.example.yuan.sub_jiequ;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String str = "https://m.360buyimg.com/n0/jfs/t9004/210/1160833155/647627/ad6be059/59b4f4e1N9a2b1532.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t7504/338/63721388/491286/f5957f53/598e95f1N7f2adb87.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t7441/10/64242474/419246/adb30a7d/598e95fbNd989ba0a.jpg!q70.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sub(str);
    }

    public void sub(String str) {
        List<String> list=new ArrayList<>();
        //得到截取的角标
        int i = str.indexOf("|");
        //判断是否有角标,有的话就截取
        if (i > 0) {
            //截取为左右两边
            String subleft = str.substring(0, i);
            list.add(subleft);
            sub(str.substring(i+1,str.length()));
        }
        else
        {
            list.add(str);
            Log.i("LOG",list.size()+"");
        }

    }
}
