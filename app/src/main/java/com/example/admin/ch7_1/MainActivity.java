package com.example.admin.ch7_1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener {
    private TextView output, output_touch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = (TextView) findViewById(R.id.txv_output);
        Button btn = (Button) findViewById(R.id.btn_longclick);
        btn.setOnClickListener(this);
        btn.setOnLongClickListener(this);
        output_touch = (TextView)findViewById(R.id.txv_touch);
        FrameLayout frame = (FrameLayout)findViewById(R.id.frame);
        frame.setOnTouchListener(this);
        frame.setOnClickListener(this);
    }
    public boolean onLongClick(View v){
        output.setText("觸發LongClick事件...");
        return false; //到這裡還沒結束，還會繼續執行onClick事件
        //return true;     //執行完onLongClick事件後就結束了，不會再繼續執行下面的事件，到此為止的意思
    }
    public void onClick(View v){
        if(v.getId() == R.id.btn_longclick){
            output.setText("觸發Click事件...");
        }
    }
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Toast.makeText(this, "按下 KEYCODE_BACK鍵...",Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    public boolean onKeyUp(int keyCode, KeyEvent event){
        output.setText("按下KeyCode按鍵碼"+keyCode);
        return super.onKeyUp(keyCode, event);
    }
    public boolean onTouch(View v, MotionEvent event){
        if(v.getId() != R.id.frame) {return false;}
        int act = event.getAction();
        switch (act){
            case MotionEvent.ACTION_DOWN: //手指第1個接觸的點的座標
                output_touch.setText("ACTION_DOWN");
                output_touch.setTextColor(Color.RED);
                break;
            case MotionEvent.ACTION_UP: //手指離開螢幕，取得最後接觸點的座標
                output_touch.setText("ACTION_UP");
                output_touch.setTextColor(Color.GREEN);
                break;
            case MotionEvent.ACTION_MOVE: //移動時會顯示目前座標和尺寸
                float evt_x = event.getX(); //取得X座標
                float evt_y = event.getY(); //取得Y座標
                int v_w = v.getWidth();    //取得寬
                int v_h = v.getHeight();   //取得高
                output_touch.setText("evt_x="+evt_x+"\nevt_y="+evt_y+"\nw="+v_w+"\nh="+v_h);
                if (evt_x>=0 && evt_x<=v_w && evt_y>=0 && evt_y<=v_h)
                    output_touch.setTextColor(Color.RED);
                else
                    output_touch.setTextColor(Color.GREEN);
                break;
        }
        return false;
    }
}
