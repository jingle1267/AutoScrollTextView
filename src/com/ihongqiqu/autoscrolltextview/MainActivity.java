package com.ihongqiqu.autoscrolltextview;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;

import java.util.ArrayList;

/**
 * 测试代码
 * <p/>
 * Created by zhenguo on 3/4/15.
 */
public class MainActivity extends Activity {

    private AutoScrollTextView autoTextView;

    private ArrayList<String> titleList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        autoTextView = (AutoScrollTextView) findViewById(R.id.text_switcher);

        // 制造测试数据
        for (int i = 0; i < 15; i++) {
            titleList.add("ABC position : " + i);
        }
        autoTextView.setTextList(titleList);
        autoTextView.setOnItemClickListener(new AutoScrollTextView.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.d("", "position : " + position);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        autoTextView.startAutoScroll();
    }

    @Override
    protected void onPause() {
        super.onPause();
        autoTextView.stopAutoScroll();
    }
}