package com.example.changeactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;

/**
 * Created by Administrator on 2017/4/3 0003.
 */

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            finish();
//            overridePendingTransition(R.anim.activity_in_1,R.anim.activity_out_1);
            overridePendingTransition(R.anim.activity_in_2,R.anim.activity_out_2);
        }
        return super.onKeyDown(keyCode, event);
    }
}
