package com.example.evalutordemo;

import android.animation.FloatEvaluator;
import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ValueAnimator valueAnimator;
    private CustomTextView tv;
    private IntEvaluator intEvaluator;
    private FloatEvaluator floatEvaluator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (CustomTextView)findViewById(R.id.tv);
        valueAnimator = new ValueAnimator();
        valueAnimator.setObjectValues(new Character('A'),new Character('Z'));
        valueAnimator.setEvaluator(new CharEvalutor());
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setTarget(tv);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                char value = (char) animation.getAnimatedValue();
                tv.setText1(value);
            }
        });
        valueAnimator.setDuration(25000);
    }

    public void startAnimator(View view){
        valueAnimator.start();
    }
}
