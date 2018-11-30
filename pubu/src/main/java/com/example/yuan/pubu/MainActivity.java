package com.example.yuan.pubu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> strList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        strList = new ArrayList<>();
        initView();

    }

    private void initView() {
        final EditText input=findViewById(R.id.input);
        final CustomWaterFallViewGroup customWaterFallViewGroup=findViewById(R.id.water);
        Button button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取输入框的文字
                String s = input.getText().toString();
                //将文字放入列表
                strList.add(s);
                //s设置数据
                customWaterFallViewGroup.setStringList(strList);
            }
        });

    }
}
