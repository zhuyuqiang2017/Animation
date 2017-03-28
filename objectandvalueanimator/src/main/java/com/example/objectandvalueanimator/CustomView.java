package com.example.objectandvalueanimator;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/3/28 0028.
 */

public class CustomView extends TextView {
    private Character mTextChar;
    private int mTextRotate;

    public CustomView(Context context) {
        this(context, null);
    }

    public CustomView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public Character getTextChar() {
        return mTextChar;
    }

    public void setTextChar(Character character) {
        this.setText(character.toString());
    }

    public int getTextRotate() {
        return mTextRotate;
    }

    public void setTextRotate(int rotate) {
        mTextRotate = rotate;
        this.setRotation(rotate);
    }

}
