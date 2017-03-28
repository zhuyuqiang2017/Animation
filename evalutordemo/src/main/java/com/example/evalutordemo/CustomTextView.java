package com.example.evalutordemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/3/25 0025.
 */

public class CustomTextView extends View {
    private Character mText = '*';
    private Paint p;
    private Rect text;
    private Rect canvasRect;
    public CustomTextView(Context context) {
        this(context,null);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr,0);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        p = new Paint();
        p.setColor(Color.RED);
        p.setTextSize(48);
        p.setTextAlign(Paint.Align.LEFT);
        text = new Rect();
        canvasRect = new Rect();
    }


    public Character getText1(){
        char value = mText;
        return new Character(value);
    }
    public void setText1(Character c){
        mText = c;
        invalidate();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        canvasRect.left = getPaddingLeft();
        canvasRect.top = getPaddingTop();
        canvasRect.right = getWidth()-getPaddingRight();
        canvasRect.bottom = getHeight()-getPaddingBottom();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        p.setColor(Color.RED);
        p.getTextBounds(mText.toString(),0,mText.toString().length(),text);
        canvas.drawRect(canvasRect,p);
        p.setColor(Color.BLACK);
        canvas.drawText(mText.toString(),(canvasRect.width()-text.width())/2+getPaddingLeft(),canvasRect.bottom-(canvasRect.height()-text.height())/2,p);
    }
}
