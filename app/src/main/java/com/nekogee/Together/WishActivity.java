package com.nekogee.Together;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

/**
 * Created by Administrator on 2018/4/8 0008.
 */

public class WishActivity extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.wish ,container,false);
        FloatingActionButton PresentLoc = (FloatingActionButton) view.findViewById(R.id.wishFab);
        PresentLoc.setOnClickListener(new LocationCheckedListener());
        return view;
    }

    class LocationCheckedListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(getActivity(), WishEditActivity.class);
            getActivity().startActivity(intent);
        }
    }
}
