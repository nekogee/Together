package com.nekogee.Together;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.widget.DividerItemDecoration.*;

/**
 * Created by weixuan on 2018/4/10.
 */

public class ChattingFragment extends Fragment {
    private View view;

//内部peopleadapter类
     class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.ViewHolder> {
        private List<People> mPeopleList;
         class ViewHolder extends RecyclerView.ViewHolder{
            ImageView peopleImage;
            TextView peopleName;
            TextView peopleNews;
            public ViewHolder(View view){
                super(view);
                peopleImage = (ImageView)view.findViewById(R.id.people_image);
                peopleName = (TextView)view.findViewById(R.id.people_name);
                peopleNews = (TextView)view.findViewById(R.id.people_News);
            }
        }
        public PeopleAdapter(List<People> peopleList){
            mPeopleList = peopleList;
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent , int viewType){
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.people_list,parent,false);
            ViewHolder holder = new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener(){
                @Override
                //点击跳转到NewsActivity
                //消息布局还没改
                public void onClick(View v){
                    Log.d("qqqq","click in");
                    Intent intent =new Intent(getActivity().getApplicationContext(),NewsActivity.class);
                    Log.d("qqqq","click out");
                    startActivity(intent);
                }
            });
            return holder;
        }
        @Override
        public void onBindViewHolder(ViewHolder holder, int position){
            People people = mPeopleList.get(position);
            holder.peopleImage.setImageResource(people.getImageId());
            holder.peopleName.setText(people.getName());
            holder.peopleNews.setText(people.getNews());
        }
        @Override
        public int getItemCount()
        {
            return mPeopleList.size();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_chatting, container, false);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.people_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        PeopleAdapter adapter = new PeopleAdapter(getPeople());
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        return view;
    }
    private  List<People> getPeople(){
         List<People>  peopleList = new ArrayList<>();
        People one = new People("Lucy", R.drawable.pic_1,"hhhhhhh");
        peopleList.add(one);
        People two = new People("Lily", R.drawable.pic_2,"ahhhhhhh");
        peopleList.add(two);
        People three = new People("王小明", R.drawable.pic_3,"ahhhhhhh");
        peopleList.add(three);
        People four = new People("安妮", R.drawable.pic_4,"hhhhhhh");
        peopleList.add(four);
        People six = new People("马老师", R.drawable.pic_6,"ahhhhhhh");
        peopleList.add(six);
        People seven = new People("老高", R.drawable.pic_7,"hhhhhhh");
        peopleList.add(seven);
        People eight = new People("欧阳", R.drawable.pic_8,"ahhhhhhh");
        peopleList.add(eight);
        People nine = new People("本子", R.drawable.pic_9,"ahhhhhhh");
        peopleList.add(nine);
        People ten = new People("小白", R.drawable.pic_10,"hhhhhhh");
        peopleList.add(ten);
        return peopleList;
    }
}

