package com.nekogee.Together;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.SequenceInputStream;
import java.util.ArrayList;

/**
 * Created by hui jie on 2018/4/9.
 */

public class UserHomePageActivity extends AppCompatActivity {

    TabLayout tabLayout = findViewById(R.id.tab_layout);
    //ViewPager viewPager = findViewById(R.id.view_pager);
    private ArrayList<View> mList;
    private String[] mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("pppp", "begin");
        super.onCreate(savedInstanceState);
        Log.d("pppp", "b1");
        setContentView(R.layout.test_layout);
        Log.d("pppp", "b4init");
    }
}
