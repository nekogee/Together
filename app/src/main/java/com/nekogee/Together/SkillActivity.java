package com.nekogee.Together;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/8 0008.
 */

public class SkillActivity extends Fragment {
    private List<Skill> skillList = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.skill ,container,false);
        FloatingActionButton PresentLoc = (FloatingActionButton) view.findViewById(R.id.skillFab);
        PresentLoc.setOnClickListener(new LocationCheckedListener());

        recyclerView = (RecyclerView) view.findViewById(R.id.wish_view);

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
        for (int i = 0; i < 3; ++i) {
            Skill skill1 = new Skill(R.drawable.user_img3, "HHHHH", "I am HHHHH", "我的心愿标题wish3", R.drawable.wish_pic3, "我的心愿内容wishDescription3");
            skillList.add(skill1);
            Skill skill2 = new Skill(R.drawable.user_img2, "Nekogee", "I am Nekogee", "我的心愿标题wish2", R.drawable.wish_pic2, "我的心愿内容wishDescription2");
            skillList.add(skill2);
            Skill skill3 = new Skill(R.drawable.user_img1, "Jane", "I am Jane", "我的心愿标题wish1", R.drawable.wish_pic1, "我的心愿内容wishDescription1");
            skillList.add(skill3);
        }
    }

}
