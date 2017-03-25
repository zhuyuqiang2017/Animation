package com.example.objectanimatordemo;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ObjectAnimator scaleXAnimator, scaleYAnimator, rotateAnimator, alphaAnimator,rotateXAnimator;
    private ObjectAnimator rotateYAnimator,translationXAnimator,translationYAnimator;
    private AnimatorSet animatorSet;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.iv);
        initAnimator();
    }

   public void initAnimator(){
       scaleXAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.scale_x_animator);
       scaleYAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.scale_y_animator);
       rotateAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.rotate_z_animator);
       alphaAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.alpha_animator);
       rotateXAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.rotate_x_animator);
       rotateYAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.rotate_y_animator);
       translationXAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.transilation_x_animator);
       translationYAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.transilation_y_animator);
       animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this,R.animator.set_animator);
    }

    public void startScaleXAnimator(View view) {
        scaleXAnimator.setTarget(iv);
        scaleXAnimator.start();
    }

    public void startScaleYAnimator(View view) {
        scaleYAnimator.setTarget(iv);
        scaleYAnimator.start();
    }

    public void startAlphaAnimator(View view) {
        alphaAnimator.setTarget(iv);
        alphaAnimator.start();
    }

    public void startRotateAnimator(View view) {
        rotateAnimator.setTarget(iv);
        rotateAnimator.start();
    }

    public void startRotateXAnimator(View view) {
        rotateXAnimator.setTarget(iv);
        rotateXAnimator.start();
    }

    public void startRotateYAnimator(View view) {
        rotateYAnimator.setTarget(iv);
        rotateYAnimator.start();
    }

    public void startTranslationXAnimator(View view) {
        translationXAnimator.setTarget(iv);
        translationXAnimator.start();
    }

    public void startTranslationYAnimator(View view) {
        translationYAnimator.setTarget(iv);
        translationYAnimator.start();
    }

    public void startSetAnimator(View view){
        animatorSet.setTarget(iv);
        animatorSet.start();
    }
}
