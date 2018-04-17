package com.example.admin.ch7_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {
    private TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = (TextView) findViewById(R.id.txv_output);
        Button btn = (Button) findViewById(R.id.btn_longclick);
        btn.setOnClickListener(this);
        btn.setOnLongClickListener(this);
    }
    public boolean onLongClick(View v){
        output.setText("觸發LongClick事件...");
        return false; //到這裡還沒結束，還會繼續執行onClick事件
        //return true;     //執行完onLongClick事件後就結束了，不會再繼續執行下面的事件，到此為止的意思
    }
    public void onClick(View v){
        output.setText("觸發Click事件...");
    }
}
