package com.nekogee.Together;

/**
 * Created by weixuan on 2018/4/8.
 */

public class Msg {
    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SENT = 1;
    private String content;
    private int type;
    private  String name;
    public  Msg(String content,int type){
        this.content = content;
        this.type = type;

    }
    public String getContent(){
        return content;
    }
    public int getType(){
        return type;
    }
    public String getName(){
        return name;
    }
}
