package com.example.interpolatordemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.PathInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;
    private ScaleAnimation scaleAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.iv);
        scaleAnimation = (ScaleAnimation) AnimationUtils.loadAnimation(MainActivity.this,R.anim.scale_animation);
    }

    public void setAccelerateDecelerate(View view){
        AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();//加速减速插值器，产生一定视觉上快慢的效果
        scaleAnimation.setInterpolator(accelerateDecelerateInterpolator);
        iv.startAnimation(scaleAnimation);
    }
    public void setAccelerate(View view){
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();//在没有使用插值器的情况下，默认使用加速度插值器
        scaleAnimation.setInterpolator(accelerateInterpolator);
        iv.startAnimation(scaleAnimation);
    }
    public void setLinear(View view){
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        scaleAnimation.setInterpolator(linearInterpolator);
        iv.startAnimation(scaleAnimation);
    }
    public void setAnticipate(View view){
        AnticipateInterpolator anticipateInterpolator = new AnticipateInterpolator(1.0f);
        scaleAnimation.setInterpolator(anticipateInterpolator);
        iv.startAnimation(scaleAnimation);
    }
    public void setAnticipateOvershoot(View view){
        AnticipateOvershootInterpolator anticipateOvershootInterpolator = new AnticipateOvershootInterpolator();
        scaleAnimation.setInterpolator(anticipateOvershootInterpolator);
        iv.startAnimation(scaleAnimation);
    }
    public void setCycle(View view){
        CycleInterpolator cycleInterpolator = new CycleInterpolator(1.0f);//出入的值影响差值器的返回值，计算公式：sin（2pi*cycle*factor），其中factor的取值为0到1，
        scaleAnimation.setInterpolator(cycleInterpolator);               //cycle为构造方法传入的float值
        iv.startAnimation(scaleAnimation);
    }
    public void setPath(View view){
        PathInterpolator pathInterpolator = new PathInterpolator(0.3f,0.3f,0.7f,0.7f);//主要就是使用贝塞尔曲线，就不多说了，我不太懂
        scaleAnimation.setInterpolator(pathInterpolator);
        iv.startAnimation(scaleAnimation);
    }
    public void setOvershoot(View view){
        OvershootInterpolator overshootInterpolator = new OvershootInterpolator(0.5f);//使用无参构造方法，默认mTension的值会设置为2.0f
        scaleAnimation.setInterpolator(overshootInterpolator);
        iv.startAnimation(scaleAnimation);
    }
    public void setBounce(View view){
           BounceInterpolator bounceInterpolator = new BounceInterpolator();
        scaleAnimation.setInterpolator(bounceInterpolator);
        iv.startAnimation(scaleAnimation);//弹起效果
    }
    public void setCustomInterpolator(View view){
        CustomInterpolator interpolator = new CustomInterpolator();//具体看一下代码吧，
        scaleAnimation.setInterpolator(interpolator);
        iv.startAnimation(scaleAnimation);
    }
}
