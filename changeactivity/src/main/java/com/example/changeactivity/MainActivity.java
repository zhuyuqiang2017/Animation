package com.example.changeactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void changeToSecondActivity(View view){
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);
//        overridePendingTransition(R.anim.activity_in_1,R.anim.activity_out_1);
        overridePendingTransition(R.anim.activity_in_2,R.anim.activity_out_2);
    }
}
