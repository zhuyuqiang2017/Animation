package com.example.animatorsetdemo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.drawable.ShapeDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.jar.Manifest;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout mContainer = null;
    private int mMenuCount = 0;
    private boolean VIEW_IS_OPEN = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContainer = (RelativeLayout)findViewById(R.id.activity_main);
        mMenuCount = mContainer.getChildCount()-1;
    }

    public void startToast(View view){
        ImageButton btn = (ImageButton) findViewById(view.getId());
        Toast.makeText(MainActivity.this,"v = "+btn.getContentDescription(),Toast.LENGTH_SHORT).show();
    }

    public void startAnimator(View view){
        Log.i("zyq","startAnimator");
        if(!VIEW_IS_OPEN){
            VIEW_IS_OPEN = true;
            AnimatorSet set = new AnimatorSet();
            Collection<Animator> mCollection = new ArrayList<>();
            for (int  i = 0;i<mMenuCount;i++){
                double degree = Math.toRadians(90)/(mMenuCount-1) * i;
                float translationX =  - (float)(400 * Math.sin(degree));
                float translationY = - (float)(400 * Math.cos(degree));
            mCollection.add(ObjectAnimator.ofPropertyValuesHolder(mContainer.getChildAt(i),
                    PropertyValuesHolder.ofFloat("translationX",0.0f,translationX),
                    PropertyValuesHolder.ofFloat("translationY",0.0f,translationY),
                    PropertyValuesHolder.ofFloat("scaleX",0.0f,1.0f),
                    PropertyValuesHolder.ofFloat("scaleY",0.0f,1.0f),
                    PropertyValuesHolder.ofFloat("alpha",0.0f,1.0f)));
            }
        set.setDuration(5000).setInterpolator(new BounceInterpolator());
        set.playTogether(mCollection);
        set.start();
        }else{
            AnimatorSet set = new AnimatorSet();
            Collection<Animator> mCollection = new ArrayList<>();
            for (int  i = 0;i<mMenuCount;i++){
                double degree = Math.toRadians(90)/(mMenuCount-1) * i;
                float translationX =  -(float)(400 * Math.sin(degree));
                float translationY = -(float)(400 * Math.cos(degree));
            mCollection.add(ObjectAnimator.ofPropertyValuesHolder(mContainer.getChildAt(i),
                PropertyValuesHolder.ofFloat("translationX",translationX,0.0f),
                        PropertyValuesHolder.ofFloat("translationY",translationY,0.0f),
                        PropertyValuesHolder.ofFloat("scaleX",1.0f,0.0f),
                        PropertyValuesHolder.ofFloat("scaleY",1.0f,0.0f),
                        PropertyValuesHolder.ofFloat("alpha",1.0f,0.0f)));
            }
        set.setDuration(5000).setInterpolator(new BounceInterpolator());
        set.playTogether(mCollection);
        set.start();
            VIEW_IS_OPEN = false;
        }

    }
}
