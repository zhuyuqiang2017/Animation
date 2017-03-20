package com.example.viewanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.example.viewanimation.R;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.iv);
    }

    public void startScaleAnimation(View view){
        ScaleAnimation scaleAnimation = (ScaleAnimation) AnimationUtils.loadAnimation(MainActivity.this,R.anim.scale_animation);
        imageView.startAnimation(scaleAnimation);
    }

    public void startAlphaAnimation(View view){
        AlphaAnimation alphaAnimation = (AlphaAnimation) AnimationUtils.loadAnimation(MainActivity.this,R.anim.alpha_animation);
        imageView.startAnimation(alphaAnimation);
    }

    public void startRotateAnimation(View view){
        RotateAnimation rotateAnimation = (RotateAnimation) AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotate_animation);
        imageView.startAnimation(rotateAnimation);
    }

    public void startTranslateAnimation(View view){
        TranslateAnimation translateAnimation = (TranslateAnimation) AnimationUtils.loadAnimation(MainActivity.this,R.anim.translate_animation);
        imageView.startAnimation(translateAnimation);
    }

    public void startSetAnimation(View view){
        AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(MainActivity.this,R.anim.set_animation);
        imageView.startAnimation(animationSet);
    }

}
