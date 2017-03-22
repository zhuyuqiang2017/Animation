package com.example.interpolatordemo;

import android.animation.TimeInterpolator;
import android.view.animation.Interpolator;


/**
 * Created by Administrator on 2017/3/22 0022.
 */

public class CustomInterpolator implements Interpolator{

    public CustomInterpolator(){

    }
    @Override
    public float getInterpolation(float input) {
        return 1-input;
    }
}
