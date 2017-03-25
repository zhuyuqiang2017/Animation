package com.example.evalutordemo;

import android.animation.TypeEvaluator;
import android.text.style.CharacterStyle;

/**
 * Created by Administrator on 2017/3/25 0025.
 */

public class CharEvalutor implements TypeEvaluator<Character> {
    public CharEvalutor(){}
    @Override
    public Character evaluate(float fraction, Character startValue, Character endValue) {
        char value = (char) (startValue+(endValue-startValue)*fraction);
        return value;
    }
}


