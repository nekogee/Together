package com.nekogee.Together;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    View view1 ;
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent , int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wish_item , parent , false) ;
        final ViewHolder holder = new ViewHolder(view) ;
        holder.wishTitle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Wish wish = wishList.get(holder.getAdapterPosition());
                Intent intent = new Intent(v.getContext() , MessageActivity.class) ;
                intent.putExtra("extra_userImage" , wish.getUserImage());
                intent.putExtra("extra_userName" , wish.getUserName()) ;
                intent.putExtra("extra_description" , wish.getWishDescription()) ;
                intent.putExtra("extra_descriptionImage" , wish.getWishImage()) ;
                v.getContext().startActivity(intent) ;
            }
        });
        holder.wishDescription.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Wish wish = wishList.get(holder.getAdapterPosition());
                Intent intent = new Intent(v.getContext() , MessageActivity.class) ;
                intent.putExtra("extra_userImage" , wish.getUserImage());
                intent.putExtra("extra_userName" , wish.getUserName()) ;
                intent.putExtra("extra_description" , wish.getWishDescription()) ;
                intent.putExtra("extra_descriptionImage" , wish.getWishImage()) ;
                v.getContext().startActivity(intent) ;
            }
        });
        holder.wishImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Wish wish = wishList.get(holder.getAdapterPosition());
                Intent intent = new Intent(v.getContext() , MessageActivity.class) ;
                intent.putExtra("extra_userImage" , wish.getUserImage());
                intent.putExtra("extra_userName" , wish.getUserName()) ;
                intent.putExtra("extra_description" , wish.getWishDescription()) ;
                intent.putExtra("extra_descriptionImage" , wish.getWishImage()) ;
                v.getContext().startActivity(intent) ;
            }
        });
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
