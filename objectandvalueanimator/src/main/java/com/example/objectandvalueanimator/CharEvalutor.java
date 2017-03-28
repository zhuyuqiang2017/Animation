package com.example.objectandvalueanimator;

import android.animation.TypeEvaluator;

/**
 * Created by Administrator on 2017/3/28 0028.
 */

public class CharEvalutor implements TypeEvaluator<Character> {
    @Override
    public Character evaluate(float fraction, Character startValue, Character endValue) {
       char c = (char) (startValue+(endValue-startValue)*fraction);
        return new Character(c);
    }
}
