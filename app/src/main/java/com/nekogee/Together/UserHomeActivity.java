package com.nekogee.Together;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class UserHomeActivity extends android.support.v4.app.Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("qqqq","out");

        View view = inflater.inflate(R.layout.activity_user_home, container, false);

        Log.d("qqqq","out");

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.d("qqqq","in");
        super.onActivityCreated(savedInstanceState);
        Log.d("qqqq","in");
    }

}
