package com.example.yuan.pubu2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        final EditText input=findViewById(R.id.input);
        Button button=findViewById(R.id.button);
        final WeekFlowLayout weekFlowLayout=findViewById(R.id.week);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView=new TextView(MainActivity.this);
                textView.setText(input.getText());
                weekFlowLayout.addView(textView);

            }
        });
    }
}
