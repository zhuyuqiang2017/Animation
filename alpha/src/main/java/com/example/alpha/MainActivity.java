package com.example.alpha;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = (ImageView)findViewById(R.id.image_view);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        final AlphaAnimation alpha = (AlphaAnimation) AnimationUtils.loadAnimation(MainActivity.this,R.anim.alpha);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                image.startAnimation(getAlphaAnimation());
                image.startAnimation(alpha);
            }
        });
        setImageView();
    }

    private void setImageView(){
        float density = getResources().getDisplayMetrics().density;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap mBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.test,options);
        int width = options.outWidth;
        int height = options.outHeight;
        int sample = 1;
        if (width>image.getWidth() || height>image.getHeight()){
            sample = (int) Math.max(width/(200*density),height/(200*density));
        }
        options.inSampleSize = sample;
        options.inJustDecodeBounds = false;
        mBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.test,options);
        image.setImageBitmap(mBitmap);
    }
    private AlphaAnimation getAlphaAnimation(){
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f,0.3f);
        alphaAnimation.setDuration(3000);
        alphaAnimation.setFillAfter(true);
        return alphaAnimation;
    }
}
