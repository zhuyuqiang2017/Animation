package com.example.objectandvalueanimator;

import android.animation.FloatEvaluator;
import android.animation.IntEvaluator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Property;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ObjectAnimator mObjectAnimator;
    private ValueAnimator mValueAnimator;
    private PropertyValuesHolder mHolder;
    private CustomView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (CustomView) findViewById(R.id.iv);
    }

    public void startObjectOfInt(View view) {
        mObjectAnimator = ObjectAnimator.ofInt(iv, "TextRotate", 0, 90, 180, 90, 0);
        mObjectAnimator.setDuration(5000);
        mObjectAnimator.setInterpolator(new BounceInterpolator());
        mObjectAnimator.start();
    }

    public void startObjectOfFloat(View view) {
        mObjectAnimator = ObjectAnimator.ofFloat(iv, "RotationY", 0, 90, 180, 90, 0);
        mObjectAnimator.setDuration(5000);
        mObjectAnimator.setInterpolator(new BounceInterpolator());
        mObjectAnimator.start();
    }

    public void startObjectOfObject(View view) {
        mObjectAnimator = ObjectAnimator.ofObject(iv, "RotationY", new IntEvaluator(), 0, 90, 180, 90, 0);
        mObjectAnimator.setDuration(5000);
        mObjectAnimator.setInterpolator(new BounceInterpolator());
        mObjectAnimator.start();
    }

    public void startObjectOfHolder(View view) {
        PropertyValuesHolder holder1 = PropertyValuesHolder.ofInt("TextRotate", 0, 90, 180, 90, 0);
        PropertyValuesHolder holder2 = PropertyValuesHolder.ofObject("TextChar", new CharEvalutor(), 'A', 'Z');
        mObjectAnimator = mObjectAnimator.ofPropertyValuesHolder(iv, holder1, holder2);
        mObjectAnimator.setDuration(5000);
        mObjectAnimator.setInterpolator(new BounceInterpolator());
        mObjectAnimator.start();
    }

    public void startValueOfInt(View view) {
        if(mObjectAnimator != null){
            mObjectAnimator.setTarget(null);
        }
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 90, 180, 90, 0);
        valueAnimator.setDuration(5000);
        valueAnimator.setInterpolator(new CycleInterpolator(2.0f));
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                iv.setTextRotate((Integer) animation.getAnimatedValue());
            }
        });
        valueAnimator.start();
    }

    public void startValueOfFloat(View view) {
        if(mObjectAnimator != null){
            mObjectAnimator.setTarget(null);
        }
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 90f, 180f, 90f, 0f);
        valueAnimator.setDuration(5000);
        valueAnimator.setInterpolator(new CycleInterpolator(2.0f));
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                iv.setTextRotate((int) value);
            }
        });
        valueAnimator.start();
    }

    public void startValueOfObject(View view) {
        if(mObjectAnimator != null){
            mObjectAnimator.setTarget(null);
        }
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new FloatEvaluator(), 0f, 90f, 180f, 90f, 0f);
        valueAnimator.setDuration(5000);
        valueAnimator.setInterpolator(new CycleInterpolator(2.0f));
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                iv.setTextRotate((int) value);
            }
        });
        valueAnimator.start();
    }

    public void startValueOfHolder(View view) {
        if(mObjectAnimator != null){
            mObjectAnimator.setTarget(null);
        }
//        PropertyValuesHolder holder1 = PropertyValuesHolder.ofInt("TextRotate", 0, 90, 180, 90, 0);
//        PropertyValuesHolder holder2 = PropertyValuesHolder.ofObject("TextChar", new CharEvalutor(), 'A', 'Z');
//        ValueAnimator valueAnimator = ValueAnimator.ofPropertyValuesHolder(holder1, holder2);
//        valueAnimator.setDuration(5000);
//        valueAnimator.setInterpolator(new CycleInterpolator(2.0f));
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                int rotate = (int) animation.getAnimatedValue("TextRotate");
//                Character c = (Character) animation.getAnimatedValue("TextChar");
//                iv.setTextChar(c);
//                iv.setTextRotate(rotate);
//            }
//        });
//        valueAnimator.start();

        Keyframe keyframe1 = Keyframe.ofFloat(0.0f,0f);
        Keyframe keyframe2 = Keyframe.ofFloat(1.0f,180f);
        PropertyValuesHolder holder3 = PropertyValuesHolder.ofKeyframe("TextRotate",keyframe1,keyframe2);
        Keyframe keyframe3 = Keyframe.ofObject(0.0f,'A');
        Keyframe keyframe4 = Keyframe.ofObject(1.0f,'Z');
        PropertyValuesHolder holder4 = PropertyValuesHolder.ofKeyframe("TextChar",keyframe3,keyframe4);
        holder4.setEvaluator(new CharEvalutor());
        ValueAnimator valueAnimator = ValueAnimator.ofPropertyValuesHolder(holder3, holder4);
        valueAnimator.setDuration(5000);
        valueAnimator.setInterpolator(new CycleInterpolator(2.0f));
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float rotate = (float) animation.getAnimatedValue("TextRotate");
                Character c = (Character) animation.getAnimatedValue("TextChar");
                iv.setTextChar(c);
                iv.setTextRotate((int) rotate);
            }
        });
        valueAnimator.start();
    }
}
