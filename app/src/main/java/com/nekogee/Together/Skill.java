package com.nekogee.Together;

/**
 * Created by Administrator on 2018/4/11 0011.
 */

public class Skill {
    private int userImage ;
    private String userName ;
    private String userDescription ;
    private String skillTitle ;
    private int skillImage ;
    private String skillDescription ;

    public Skill(int userImage , String userName , String userDescription , String skillTitle , int skillImage , String skillDescription){
        this.userImage = userImage ;
        this.userName = userName ;
        this.userDescription = userDescription ;
        this.skillTitle = skillTitle ;
        this.skillImage = skillImage ;
        this.skillDescription = skillDescription ;
    }

    public int getUserImage(){
        return userImage ;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public String getSkillTitle() {
        return skillTitle;
    }

    public int getSkillImage() {
        return skillImage;
    }

    public String getSkillDescription() {
        return skillDescription;
    }
}
