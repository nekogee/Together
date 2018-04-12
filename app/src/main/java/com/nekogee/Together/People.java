package com.nekogee.Together;

/**
 * Created by weixuan on 2018/4/10.
 */


public class People {
    private String name;
    private int ImageId;
    private String news;
    public People(String name,int ImageId,String news){
        this.name = name;
        this.ImageId=ImageId;
        this.news = news;
    }
    public String getName(){
        return name;
    }
    public int getImageId(){
        return  ImageId;
    }
    public String getNews(){return  news;}
}
