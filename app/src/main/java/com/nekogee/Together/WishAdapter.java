package com.nekogee.Together;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2018/4/11 0011.
 */

public class WishAdapter extends RecyclerView.Adapter<WishAdapter.ViewHolder> {
    private List<Wish> wishList ;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView userImage ;
        TextView userName ;
        TextView userDescription ;
        TextView wishTitle ;
        ImageView wishImage ;
        TextView wishDescription ;

        public ViewHolder(View view){
            super(view) ;
            userImage = (ImageView)view.findViewById(R.id.wish_userImage) ;
            userName = (TextView)view.findViewById(R.id.wish_userName) ;
            userDescription = (TextView)view.findViewById(R.id.wish_userDescription) ;
            wishImage = (ImageView)view.findViewById(R.id.wishImage) ;
            wishTitle = (TextView)view.findViewById(R.id.wishTitle) ;
            wishDescription = (TextView)view.findViewById(R.id.wishDescription) ;
        }
    }

    public WishAdapter(List<Wish> wishList){
        this.wishList = wishList ;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent , int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wish_item , parent , false) ;
        ViewHolder holder = new ViewHolder(view) ;
        return holder ;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder , int position){
        Wish wish = wishList.get(position) ;
        holder.userImage.setImageResource(wish.getUserImage());
        holder.userName.setText(wish.getUserName());
        holder.userDescription.setText(wish.getUserDescription());
        holder.wishTitle.setText(wish.getWishTitle());
        holder.wishImage.setImageResource(wish.getWishImage());
        holder.wishDescription.setText(wish.getWishDescription());
    }

    @Override
    public int getItemCount(){
        return wishList.size() ;
    }

}
