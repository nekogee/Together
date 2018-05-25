package com.nekogee.Together;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class UserHomeActivity extends android.support.v4.app.Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("qqqq","out");

        View view = inflater.inflate(R.layout.activity_user_home, container, false);

        Log.d("qqqq","out");

        LinearLayout linearLayout = view.findViewById(R.id.tab_1);
        linearLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Log.d("pppp","b4add");
                Intent intent = new Intent(getActivity().getApplicationContext(),UserHomePageActivity.class);
                Log.d("pppp","b4add");
                startActivity(intent);
                //Intent intent = new Intent(UserHomeActivity.this,UserHomePageActivity.class);
                //startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.d("qqqq","in");
        super.onActivityCreated(savedInstanceState);
        Log.d("qqqq","in");
    }

}
