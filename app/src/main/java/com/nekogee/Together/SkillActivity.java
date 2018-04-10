package com.nekogee.Together;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Administrator on 2018/4/8 0008.
 */

public class SkillActivity extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.skill ,container,false);
        FloatingActionButton PresentLoc = (FloatingActionButton) view.findViewById(R.id.skillFab);
        PresentLoc.setOnClickListener(new LocationCheckedListener());
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
}
