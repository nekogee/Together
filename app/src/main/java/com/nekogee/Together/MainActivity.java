package com.nekogee.Together;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ashokvarma.bottomnavigation.TextBadgeItem;
import com.nekogee.Together.db.UserInfo;

import org.litepal.tablemanager.Connector;

/**
 * Created by hui jie on 2018/4/6.
 */

public class MainActivity extends  AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setNavigationBarColor(Color.parseColor("#000000"));
        Intent editIntent = getIntent();
        int editNumber = editIntent.getIntExtra("editChange",0);//判断是从哪个Activity跳转过来的

        if(editNumber == 0) {    //app初始页面
            //默认初始活动
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            editNumber = 1 ;
        }
        if(editNumber == 1) {    //从WishEditActivity跳转过来
            replaceFragment(new WishActivity());
        }

        if(editNumber == 2)      //从SkillEditActivity跳转过来
            replaceFragment(new SkillActivity());

/*会出bug的语句↓↓↓*/
            //    Connector.getDatabase();
            UserInfo userInfo = new UserInfo();
            userInfo.setBio("大家好");
            userInfo.setFollower(40);
            userInfo.setFollowing(23);
            userInfo.setImageID(R.drawable.pic_1);
            userInfo.setSkill("skill");
            userInfo.setWish("wish");
            userInfo.setUsername("nekogee");
            userInfo.save();

            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            ActionBar actionBar = getSupportActionBar();

            //未读消息提示
            TextBadgeItem numberBadgeItem = new TextBadgeItem();

            BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
            //bottomNavigationBar.setFab(floatingActionButton);
            bottomNavigationBar.clearAll();


            bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
            // bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
            bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
            bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.ic_favorite_border_black_36dp, "心愿").setActiveColorResource(R.color.colorPrimary))
                    .addItem(new BottomNavigationItem(R.drawable.ic_lightbulb_outline_black_36dp, "技能").setActiveColorResource(R.color.colorPrimary))
                    .addItem(new BottomNavigationItem(R.drawable.ic_question_answer_black_36dp, "消息").setActiveColorResource(R.color.colorPrimary).setBadgeItem(numberBadgeItem))
                    .addItem(new BottomNavigationItem(R.drawable.ic_perm_identity_black_36dp, "我的").setActiveColorResource(R.color.colorPrimary))
                    .setFirstSelectedPosition(editNumber-1)
                    .initialise();
            //未读消息数
            numberBadgeItem.setText("5");
            Log.d("qqqq", "000b");
        //下方导航栏的选择事件
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener(){
            @Override
            public void onTabSelected(int position) {
                switch (position) {
                    case 0: {
                        Log.d("qqqq","000b");
                        replaceFragment(new WishActivity());
                        Log.d("qqqq","000a");
                    }
                        break;
                    case 1:  {
                        Log.d("qqqq","111b");
                        replaceFragment(new SkillActivity());
                        Log.d("qqqq","111b");
                    }
                        break;
                    case 2: replaceFragment(new ChattingFragment());
                        break;
                    case 3: replaceFragment(new UserHomeActivity());
                        break;
                    default:
                }
            }
            @Override
            public void onTabUnselected(int position) {
            }
            @Override
            public void onTabReselected(int position) {
            }
        });

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment,fragment);
        Log.d("qqqq","ino");
        transaction.commit();
    }





}
