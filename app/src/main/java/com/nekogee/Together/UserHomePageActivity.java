package com.nekogee.Together;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nekogee.Together.db.UserInfo;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;

/**
 * Created by hui jie on 2018/4/9.
 */

public class UserHomePageActivity extends AppCompatActivity {

    //TabLayout tabLayout = findViewById(R.id.tab_layout);
    //ViewPager viewPager = findViewById(R.id.view_pager);
    private ArrayList<View> mList;
    private String[] mTitle;
    private TextView following;
    private TextView follower;
    private TextView username;
    private TextView bio;
    private ImageView imageView;
    private Button button;
    private Toolbar toolbar;

    private TabLayout mTabLayout;
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_personal);


        follower = findViewById(R.id.user_personal_follower1);
        following = findViewById(R.id.user_personal_following1);
        username = findViewById(R.id.user_personal_username1);
        bio = findViewById(R.id.user_personal_bio1);
        imageView = findViewById(R.id.user_personal_image1);
        // button = findViewById(R.id.button_user1);
        toolbar = findViewById(R.id.toolbar1);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        UserInfo userInfo = DataSupport.findFirst(UserInfo.class);
        //Log.d("userinfo", "onCreate: "+userInfo.getFollowing());

        following.setText("30");
        follower.setText("132");
        username.setText("nekogee");
        imageView.setImageResource(R.drawable.pic2);
        bio.setText("to be the GOAT");

        initView();
        initViewPager();

    }
    private void initView() {
        mTabLayout = findViewById(R.id.tablayout1);
        mViewPager = findViewById(R.id.viewpager1);
    }

    private void initViewPager() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new UserWishFragment());
        fragments.add(new UserSkillFragment());
        // 创建ViewPager适配器
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        myPagerAdapter.setFragments(fragments);
        // 给ViewPager设置适配器
        mViewPager.setAdapter(myPagerAdapter);

        mTabLayout.addTab(mTabLayout.newTab());
        mTabLayout.addTab(mTabLayout.newTab());

        mTabLayout.setupWithViewPager(mViewPager);

        mTabLayout.getTabAt(0).setText("我的心愿");
        mTabLayout.getTabAt(1).setText("我的技能");

    }
}
