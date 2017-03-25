package com.example.valueanimatordemo;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ValueAnimator mValueAnimator;
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mValueAnimator = new ValueAnimator();
        mValueAnimator.setFloatValues(0.0f,1.0f,2.0f,3.0f);
        mValueAnimator.setDuration(5000);
        mValueAnimator.setInterpolator(new BounceInterpolator());
        iv = (ImageView) findViewById(R.id.iv);
        mValueAnimator.setEvaluator(null);
    }
    public void startScaleXAnimator(View view) {
        mValueAnimator.removeAllUpdateListeners();
        final float ivScaleX = iv.getScaleX();
        AnimatorUpdateListener scaleX = new AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float rate = (float) animation.getAnimatedValue();
                iv.setScaleX(ivScaleX*(1+rate));
            }
        };
        mValueAnimator.setTarget(null);
        mValueAnimator.addUpdateListener(scaleX);
        mValueAnimator.start();
    }

    public void startScaleYAnimator(View view) {
        mValueAnimator.removeAllUpdateListeners();
        final float ivScaleY = iv.getScaleY();
        AnimatorUpdateListener scaleY = new AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float rate = (float) animation.getAnimatedValue();
                iv.setScaleY(ivScaleY*(1+rate));
            }
        };
        mValueAnimator.setTarget(null);
        mValueAnimator.addUpdateListener(scaleY);
        mValueAnimator.start();
    }

    public void startAlphaAnimator(View view) {
        mValueAnimator.removeAllUpdateListeners();
        mValueAnimator.setFloatValues(1.0f,0.3f);
        final float alpha = iv.getAlpha();
        AnimatorUpdateListener mAlpha = new AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float rate = (float) animation.getAnimatedValue();
                iv.setAlpha(rate*alpha);
            }
        };
        mValueAnimator.setTarget(null);
        mValueAnimator.addUpdateListener(mAlpha);
        mValueAnimator.start();
    }

    public void startRotateAnimator(View view) {
        mValueAnimator.removeAllUpdateListeners();
        mValueAnimator.setFloatValues(0.0f,360f);
        AnimatorUpdateListener mRotate = new AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                iv.setRotation(value);
            }
        };
        mValueAnimator.setTarget(null);
        mValueAnimator.addUpdateListener(mRotate);
        mValueAnimator.start();
    }

    public void startRotateXAnimator(View view) {
        mValueAnimator.removeAllUpdateListeners();
        mValueAnimator.setFloatValues(0.0f,360f);
        AnimatorUpdateListener mRotateX = new AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                iv.setRotationX(value);
            }
        };
        mValueAnimator.setTarget(null);
        mValueAnimator.addUpdateListener(mRotateX);
        mValueAnimator.start();
    }

    public void startRotateYAnimator(View view) {
        mValueAnimator.removeAllUpdateListeners();
        mValueAnimator.setFloatValues(0.0f,360f);
        AnimatorUpdateListener mRotateY = new AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                iv.setRotationY(value);
            }
        };
        mValueAnimator.setTarget(null);
        mValueAnimator.addUpdateListener(mRotateY);
        mValueAnimator.start();
    }

    public void startTranslationXAnimator(View view) {
        mValueAnimator.removeAllUpdateListeners();
        mValueAnimator.setFloatValues(0,0f,400f);
        AnimatorUpdateListener mLocationX = new AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
//                iv.setX(value);//滑动的起始点为原点
                iv.setTranslationX(value);//滑动的起始点为view所在的X点
            }
        };
        mValueAnimator.setTarget(null);
        mValueAnimator.addUpdateListener(mLocationX);
        mValueAnimator.start();
    }

    public void startTranslationYAnimator(View view) {
        mValueAnimator.removeAllUpdateListeners();
        mValueAnimator.setFloatValues(0,0f,400f);
        AnimatorUpdateListener mLocationY = new AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                float rate = animation.getAnimatedFraction();
//                iv.setY(value);//滑动的起始点为原点
                iv.setTranslationY(value);//滑动的起始点为view所在的X点
            }
        };
        mValueAnimator.setTarget(null);
        mValueAnimator.addUpdateListener(mLocationY);
        mValueAnimator.start();
    }

    public void startSetAnimator(View view){
        mValueAnimator.removeAllUpdateListeners();
        mValueAnimator.setFloatValues(1.0f,0.3f);
        final float alpha = iv.getAlpha();
        final float scaleX = iv.getScaleX();
        final float scaleY = iv.getScaleY();
        AnimatorUpdateListener set = new AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float rate = (float) animation.getAnimatedFraction();
                iv.setScaleX(scaleX+(rate*scaleX)*3);
                iv.setScaleY(scaleY+(rate*scaleY)*3);
                iv.setRotation(rate*360f);
//                iv.setRotationX(rate*360f);
//                iv.setRotationY(rate*360f);
                iv.setAlpha(rate*alpha);
                if(iv.getAlpha()<0.3){
                    iv.setAlpha(0.3f);
                }
            }
        };
        mValueAnimator.setTarget(null);
        mValueAnimator.addUpdateListener(set);
        mValueAnimator.start();
    }
}
