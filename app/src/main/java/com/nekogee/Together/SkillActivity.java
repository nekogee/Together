package com.nekogee.Together;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/*import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;*/

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/8 0008.
 */

public class SkillActivity extends Fragment {
    private static List<Skill> skillList = new ArrayList<>();
    private RecyclerView recyclerView;
 //   public LocationClient mLocationClient;
    private TextView positionText ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.skill ,container,false);
        FloatingActionButton PresentLoc = (FloatingActionButton) view.findViewById(R.id.skillFab);
        PresentLoc.setOnClickListener(new LocationCheckedListener());
        recyclerView = (RecyclerView) view.findViewById(R.id.skill_view);
        positionText = (TextView)view.findViewById(R.id.addressText) ;
        return view;
    }

    class LocationCheckedListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(getActivity(), SkillEditActivity.class);
            getActivity().startActivity(intent);
        }
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        createSkill();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);
        SkillAdapter adapter = new SkillAdapter(skillList);
        recyclerView.setAdapter(adapter);

    }

    private void createSkill() {
        if(skillList.isEmpty()) {
            for (int i = 0; i < 1; ++i) {
                Skill skill1 = new Skill(R.drawable.user_img3, "lemon", "啊你在看我", "可以帮大家寄养宠物~", R.drawable.wish_pic3, "最近比较有空，我也很喜欢小动物，可以免费帮大家寄养小动物！");
                skillList.add(skill1);
                Skill skill2 = new Skill(R.drawable.user_img2, "Bobby", "I am Bobby", "我是万事屋", R.drawable.wish_pic2, "没错，我就是传说中的万事屋！");
                skillList.add(skill2);

            }
        }

        Intent intent = getActivity().getIntent() ;
        int EditImage = intent.getIntExtra("skill_extra_editImage" , -1) ;
        if(EditImage == -1) {

        }
        else{
            String EditTitle = intent.getStringExtra("skill_extra_editTitle");
            String EditDescription = intent.getStringExtra("skill_extra_editDescription");
            String EditExtra = intent.getStringExtra("skill_extra_editExtra");

            Skill skill_add = new Skill(R.drawable.pic2, "Nekogee", "我的个性签名", EditTitle, R.drawable.user_img4, EditDescription + "\n\n我的回报：\n" + EditExtra);
            skillList.add(0,skill_add);
            intent.putExtra("skill_extra_editImage" , -1) ;
        }
    }

}
