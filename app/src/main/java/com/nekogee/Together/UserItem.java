package com.nekogee.Together;

/**
 * Created by hui jie on 2018/4/7.
 */

public class UserItem {
    private int imageId;
    private String itemName;
    public UserItem(int imageId,String itemName) {
        this.imageId = imageId;
        this.itemName = itemName;
    }
    public int getImageId() {
        return imageId;
    }
    public String getItemName() {
        return itemName;
    }
}
