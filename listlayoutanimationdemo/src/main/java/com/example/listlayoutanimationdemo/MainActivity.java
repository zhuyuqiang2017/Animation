package com.example.listlayoutanimationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.LayoutAnimationController;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private SimpleAdapter mAdapter;
    private LayoutAnimationController l;
    List<HashMap<String, String>> mData = new ArrayList<>();
    List<HashMap<String, String>> data = new ArrayList<>();
    private LinearLayout mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        mContainer = (LinearLayout)findViewById(R.id.activity_main);
        mListView = (ListView) findViewById(R.id.list_view);
        mAdapter = new SimpleAdapter(MainActivity.this, mData, android.R.layout.simple_list_item_1, new String[]{"index"}, new int[]{android.R.id.text1});
        mListView.setAdapter(mAdapter);
    }

    private void init() {
        HashMap<String, String> mWindCode = null;
        mWindCode = new HashMap<>();
        mWindCode.put("index", "无持续风向");
        mData.add(mWindCode);
        data.add(mWindCode);
        mWindCode = new HashMap<>();
        mWindCode.put("index", "东北风");
        mData.add(mWindCode);
        data.add(mWindCode);
        mWindCode = new HashMap<>();
        mWindCode.put("index", "东风");
        mData.add(mWindCode);
        mWindCode = new HashMap<>();
        mWindCode.put("index", "东南风");
        mData.add(mWindCode);
        data.add(mWindCode);
        mWindCode = new HashMap<>();
        mWindCode.put("index", "南风");
        mData.add(mWindCode);
        mWindCode = new HashMap<>();
        mWindCode.put("index", "西南风");
        mData.add(mWindCode);
        data.add(mWindCode);
        mWindCode = new HashMap<>();
        mWindCode.put("index", "西风");
        mData.add(mWindCode);
        mWindCode = new HashMap<>();
        mWindCode.put("index", "西北风");
        mData.add(mWindCode);
        data.add(mWindCode);
        mWindCode = new HashMap<>();
        mWindCode.put("index", "北风");
        mData.add(mWindCode);
        mWindCode = new HashMap<>();
        mWindCode.put("index", "旋转风");
        mData.add(mWindCode);
        data.add(mWindCode);

    }

}
