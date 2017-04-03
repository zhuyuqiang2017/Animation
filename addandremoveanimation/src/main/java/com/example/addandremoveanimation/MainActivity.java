package com.example.addandremoveanimation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mViewContainer;
    private int mViewCount = 0;
    private boolean isTransitionFinish = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewContainer = (LinearLayout) findViewById(R.id.view_container);
        LayoutTransition mLayoutTransition = new LayoutTransition();
        mLayoutTransition.setAnimator(LayoutTransition.APPEARING, getAppearingAnimation());
        mLayoutTransition.setDuration(LayoutTransition.APPEARING, 200);
        mLayoutTransition.setStartDelay(LayoutTransition.APPEARING, 0);//源码中带有默认300毫秒的延时，需要移除，不然view添加效果不好！！

        mLayoutTransition.setAnimator(LayoutTransition.DISAPPEARING, getDisappearingAnimation());
        mLayoutTransition.setDuration(LayoutTransition.DISAPPEARING, 200);

        mLayoutTransition.setAnimator(LayoutTransition.CHANGE_APPEARING,getAppearingChangeAnimation());
        mLayoutTransition.setDuration(200);

        mLayoutTransition.setAnimator(LayoutTransition.CHANGE_DISAPPEARING,getDisappearingChangeAnimation());
        mLayoutTransition.setDuration(200);

        mLayoutTransition.enableTransitionType(LayoutTransition.CHANGE_DISAPPEARING);
        mLayoutTransition.setStartDelay(LayoutTransition.CHANGE_DISAPPEARING, 0);//源码中带有默认300毫秒的延时，需要移除，不然view添加效果不好！！
        mLayoutTransition.addTransitionListener(new LayoutTransition.TransitionListener() {
            @Override
            public void startTransition(LayoutTransition transition, ViewGroup container, View view, int transitionType) {
                Log.i("zyq","LayoutTransition:startTransition");
            }

            @Override
            public void endTransition(LayoutTransition transition, ViewGroup container, View view, int transitionType) {
                Log.i("zyq","LayoutTransition:endTransition");
                isTransitionFinish = true;
            }
        });
        mViewContainer.setLayoutTransition(mLayoutTransition);
    }

    private Animator getAppearingAnimation() {
        AnimatorSet mSet = new AnimatorSet();
        mSet.playTogether(ObjectAnimator.ofFloat(null, "ScaleX", 2.0f, 1.0f),
                ObjectAnimator.ofFloat(null, "ScaleY", 2.0f, 1.0f),
                ObjectAnimator.ofFloat(null, "Alpha", 0.0f, 1.0f),
                ObjectAnimator.ofFloat(null,"translationX",400,0));
        return mSet;
    }

    private Animator getDisappearingAnimation() {
        AnimatorSet mSet = new AnimatorSet();
        mSet.playTogether(ObjectAnimator.ofFloat(null, "ScaleX", 1.0f, 0f),
                ObjectAnimator.ofFloat(null, "ScaleY", 1.0f, 0f),
                ObjectAnimator.ofFloat(null, "Alpha", 1.0f, 0.0f),ObjectAnimator.ofFloat(null,"translationX",0,400));
        return mSet;
    }

    private Animator getDisappearingChangeAnimation(){
        PropertyValuesHolder pvhLeft = PropertyValuesHolder.ofInt("left", 0, 1);
        PropertyValuesHolder pvhTop = PropertyValuesHolder.ofInt("top", 0, 1);
        PropertyValuesHolder pvhRight = PropertyValuesHolder.ofInt("right", 0, 1);
        PropertyValuesHolder pvhBottom = PropertyValuesHolder.ofInt("bottom", 0, 0);
        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX",1.0f,0f,1.0f);
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY",1.0f,0f,1.0f);
        PropertyValuesHolder rotate = PropertyValuesHolder.ofFloat("rotation",0,0,0);
        return ObjectAnimator.ofPropertyValuesHolder((Object)null,pvhLeft, pvhTop, pvhRight, pvhBottom,scaleX,scaleY,rotate);
    }

    private Animator getAppearingChangeAnimation(){
        PropertyValuesHolder pvhLeft = PropertyValuesHolder.ofInt("left", 0, 1);
        PropertyValuesHolder pvhTop = PropertyValuesHolder.ofInt("top", 0, 1);
        PropertyValuesHolder pvhRight = PropertyValuesHolder.ofInt("right", 0, 1);
        PropertyValuesHolder pvhBottom = PropertyValuesHolder.ofInt("bottom", 0, 1);
        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX",1.0f,3f,1.0f);
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY",1.0f,3f,1.0f);
        return ObjectAnimator.ofPropertyValuesHolder((Object)null,pvhLeft, pvhTop, pvhRight, pvhBottom,scaleX,scaleY);
    }

    @SuppressLint("StringFormatInvalid")
    public void addViewToParent(View view) {
        if (isTransitionFinish){
            isTransitionFinish = false;
            View view1 = LayoutInflater.from(this).inflate(R.layout.xxxx, mViewContainer, false);
            ((Button) view1).setText(getString(R.string.add_view_content, mViewCount));
            mViewContainer.addView(view1,0);
            mViewCount++;
        }
    }

    public void removeViewFromParent(View view) {
        if(isTransitionFinish){
            if (mViewCount >= 1) {
                isTransitionFinish = false;
                mViewContainer.removeViewAt((0));
                mViewCount--;
            }
        }
    }
}
