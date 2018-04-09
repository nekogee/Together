package com.nekogee.Together;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hui jie on 2018/4/7.
 */

public class UserItemAdapter extends RecyclerView.Adapter<UserItemAdapter.ViewHolder> {
    private List<UserItem> mUserItemList;
    private Context mContext;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView photoImage;
        TextView photoName;

        public ViewHolder(View view) {
            super(view);
            photoImage = view.findViewById(R.id.user_home_item_icon);
            photoName = view.findViewById(R.id.user_home_item_name);
        }
    }

    public UserItemAdapter(List<UserItem> PhotoList) {
        mUserItemList = PhotoList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.user_home_item,parent, false);
        ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // UserItem userItem = mUserItemList.get(holder.getAdapterPosition());

                 //  UserHomeActivity.actionStart(getActivity(), news.getTitle(), news.getContent());
            }
        });
        return holder;
    }
    /*@Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.user_home_item,parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }*/

    @Override
    public void onBindViewHolder(ViewHolder holder,int position) {
        UserItem userItem = mUserItemList.get(position);
        holder.photoName.setText(userItem.getItemName());
       holder.photoImage.setImageResource(userItem.getImageId());

    }
    @Override
    public int getItemCount() {
        return mUserItemList.size();
    }
}
