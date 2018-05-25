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

public class UserWishFragment extends Fragment {
    private List<Wish> wishList = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_wish, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.user_wish_recyclerView);

        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        createWish();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);
        WishAdapter adapter = new WishAdapter(wishList);
        recyclerView.setAdapter(adapter);
    }

    private void createWish() {
        for (int i = 0; i < 3; ++i) {
            Wish wish1 = new Wish(R.drawable.user_img1, "Jane", "I am Jane", "我的心愿标题wish1", R.drawable.wish_pic1, "我的心愿内容wishDescription1");
            wishList.add(wish1);
            Wish wish2 = new Wish(R.drawable.user_img2, "Nekogee", "I am Nekogee", "我的心愿标题wish2", R.drawable.wish_pic2, "我的心愿内容wishDescription2");
            wishList.add(wish2);
            Wish wish3 = new Wish(R.drawable.user_img3, "HHHHH", "I am HHHHH", "我的心愿标题wish3", R.drawable.wish_pic3, "我的心愿内容wishDescription3");
            wishList.add(wish3);
        }
    }
}
