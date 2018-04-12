package com.nekogee.Together;

/**
 * Created by Administrator on 2018/4/11 0011.
 */

public class Wish {
    private int userImage ;
    private String userName ;
    private String userDescription ;
    private String wishTitle ;
    private int wishImage ;
    private String wishDescription ;

    public Wish(int userImage , String userName , String userDescription , String wishTitle , int wishImage , String wishDescription){
        this.userImage = userImage ;
        this.userName = userName ;
        this.userDescription = userDescription ;
        this.wishTitle = wishTitle ;
        this.wishImage = wishImage ;
        this.wishDescription = wishDescription ;
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

    public String getWishTitle(){
        return wishTitle ;
    }

    public int getWishImage() {
        return wishImage;
    }

    public String getWishDescription() {
        return wishDescription;
    }

}
