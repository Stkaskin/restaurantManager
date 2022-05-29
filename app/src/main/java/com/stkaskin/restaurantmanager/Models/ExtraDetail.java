package com.stkaskin.restaurantmanager.Models;

import com.stkaskin.restaurantmanager.FireCloud.IFirebase;

public class ExtraDetail implements IFirebase {
    String id;
    String name;
    int displayRank;
    String extraId;
    String imageId;
    String specialExtraListId;
    int status;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDisplayRank() {
        return displayRank;
    }

    public void setDisplayRank(int displayRank) {
        this.displayRank = displayRank;
    }

    public String getExtraId() {
        return extraId;
    }

    public void setExtraId(String extraId) {
        this.extraId = extraId;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getSpecialExtraListId() {
        return specialExtraListId;
    }

    public void setSpecialExtraListId(String specialExtraListId) {
        this.specialExtraListId = specialExtraListId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }



    @Override
    public String TableName() {
        return "ExtraDetail";
    }
}
