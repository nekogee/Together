package com.nekogee.Together;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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

    private TabLayout mTabLayout;
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_personal);

        follower = findViewById(R.id.user_personal_follower);
        following = findViewById(R.id.user_personal_following);
        username = findViewById(R.id.user_personal_username);
        bio = findViewById(R.id.user_personal_bio);
        imageView = findViewById(R.id.user_personal_image);

        UserInfo userInfo = DataSupport.findFirst(UserInfo.class);
        //Log.d("userinfo", "onCreate: "+userInfo.getFollowing());

        following.setText(""+userInfo.getFollowing());
        follower.setText(""+userInfo.getFollower());
        username.setText(""+userInfo.getUsername());
        imageView.setImageResource(userInfo.getImageID());
        bio.setText(userInfo.getBio()+"");

        initView();
        initViewPager();

    }
    private void initView() {
        mTabLayout = findViewById(R.id.tabLayout);
        mViewPager = findViewById(R.id.viewPager);
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
