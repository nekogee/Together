package com.nekogee.Together;

import android.content.Intent;
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

public class SkillAdapter extends RecyclerView.Adapter<SkillAdapter.ViewHolder> {
    private List<Skill> skillList ;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView userImage ;
        TextView userName ;
        TextView userDescription ;
        TextView skillTitle ;
        ImageView skillImage ;
        TextView skillDescription ;

        public ViewHolder(View view){
            super(view) ;
            userImage = (ImageView)view.findViewById(R.id.skill_userImage) ;
            userName = (TextView)view.findViewById(R.id.skill_userName) ;
            userDescription = (TextView)view.findViewById(R.id.skill_userDescription) ;
            skillImage = (ImageView)view.findViewById(R.id.skillImage) ;
            skillTitle = (TextView)view.findViewById(R.id.skillTitle) ;
            skillDescription = (TextView)view.findViewById(R.id.skillDescription) ;
        }
    }

    public SkillAdapter(List<Skill> skillList){
        this.skillList = skillList ;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent , int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.skill_item , parent , false) ;
        final ViewHolder holder = new ViewHolder(view) ;
        holder.skillTitle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Skill skill = skillList.get(holder.getAdapterPosition());
                Intent intent = new Intent(v.getContext() , MessageActivity.class) ;
                intent.putExtra("extra_userImage" , skill.getUserImage());
                intent.putExtra("extra_userName" , skill.getUserName()) ;
                intent.putExtra("extra_description" , skill.getSkillDescription()) ;
                intent.putExtra("extra_descriptionImage" , skill.getSkillImage()) ;
                v.getContext().startActivity(intent) ;
            }
        });
        holder.skillImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Skill skill = skillList.get(holder.getAdapterPosition());
                Intent intent = new Intent(v.getContext() , MessageActivity.class) ;
                intent.putExtra("extra_userImage" , skill.getUserImage());
                intent.putExtra("extra_userName" , skill.getUserName()) ;
                intent.putExtra("extra_description" , skill.getSkillDescription()) ;
                intent.putExtra("extra_descriptionImage" , skill.getSkillImage()) ;
                v.getContext().startActivity(intent) ;
            }
        });
        holder.skillDescription.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Skill skill = skillList.get(holder.getAdapterPosition());
                Intent intent = new Intent(v.getContext() , MessageActivity.class) ;
                intent.putExtra("extra_userImage" , skill.getUserImage());
                intent.putExtra("extra_userName" , skill.getUserName()) ;
                intent.putExtra("extra_description" , skill.getSkillDescription()) ;
                intent.putExtra("extra_descriptionImage" , skill.getSkillImage()) ;
                v.getContext().startActivity(intent) ;
            }
        });
        return holder ;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder , int position){
        Skill skill = skillList.get(position) ;
        holder.userImage.setImageResource(skill.getUserImage());
        holder.userName.setText(skill.getUserName());
        holder.userDescription.setText(skill.getUserDescription());
        holder.skillTitle.setText(skill.getSkillTitle());
        holder.skillImage.setImageResource(skill.getSkillImage());
        holder.skillDescription.setText(skill.getSkillDescription());
    }

    @Override
    public int getItemCount(){
        return skillList.size() ;
    }

}

