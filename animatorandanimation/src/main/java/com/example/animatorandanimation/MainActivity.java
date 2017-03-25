package com.example.animatorandanimation;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;
    private TranslateAnimation translateAnimation;
    private ObjectAnimator objectAnimator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.iv);
        translateAnimation = (TranslateAnimation) AnimationUtils.loadAnimation(MainActivity.this,R.anim.translation);
        objectAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(MainActivity.this,R.animator.translation);
    }

    public void startAnimation(View view){
        iv.startAnimation(translateAnimation);
    }

    public void startAnimator(View view){
        iv.clearAnimation();
        objectAnimator.setTarget(iv);
        objectAnimator.start();
    }

    public void showToast(View view){
        Toast.makeText(MainActivity.this,"you click the imageView",Toast.LENGTH_SHORT).show();
    }
}
