package com.example.gridviewanimationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.CycleInterpolator;
import android.view.animation.GridLayoutAnimationController;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private GridView mGridView;
    private SimpleAdapter mAdapter;
    private List<HashMap<String,String>> mData;
    private GridLayoutAnimationController mController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGridView = (GridView) findViewById(R.id.grid_view);
        initData();
        mController = new GridLayoutAnimationController(MainActivity.this,null);
        initAnimation();
        mAdapter = new SimpleAdapter(MainActivity.this,mData,android.R.layout.simple_list_item_1,new String[]{"index"},new int[]{android.R.id.text1});
        mGridView.setLayoutAnimation(mController);
        mGridView.setAdapter(mAdapter);

    }

    private void initAnimation(){
        mController.setColumnDelay(0.5f);
        mController.setDirection(GridLayoutAnimationController.DIRECTION_LEFT_TO_RIGHT|GridLayoutAnimationController.DIRECTION_TOP_TO_BOTTOM);
        mController.setDirectionPriority(GridLayoutAnimationController.PRIORITY_ROW);
        mController.setAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.grid_animation));
        mController.setRowDelay(0.5f);
        mController.setInterpolator(new CycleInterpolator(1.0f));
    }
    private void initData(){
        mData = new ArrayList<>();
        HashMap<String,String> mMap = null;
        for(int i = 0 ;i<27;i++){
            mMap = new HashMap<>();
            mMap.put("index","这是第"+(i+1)+"数据");
            mData.add(mMap);

        }
    }
}
