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
 * Created by hui jie on 2018/5/25.
 */

public class UserSkillFragment extends Fragment {
    private List<Skill> skillList = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_skill ,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.user_skill_recyclerView);

        return view;
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
            Skill skill1 = new Skill(R.drawable.pic2, "nekogee", "to be the GOAT", "我想", R.drawable.wish_pic1, "我的心愿内容wishDescription3");
            skillList.add(skill1);
            Skill skill2 = new Skill(R.drawable.pic2, "nekogee", "to be the GOAT", "我的心愿标题wish2", R.drawable.wish_pic1, "我的心愿内容wishDescription2");
            skillList.add(skill2);

    }

}
