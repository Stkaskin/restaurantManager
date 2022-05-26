package com.stkaskin.restaurantmanager.Models;

import com.stkaskin.restaurantmanager.FireCloud.IFirebase;

import java.util.ArrayList;

public class SpecialExtraList implements IFirebase {    String id;
    String displayRank;
    String name;
    int status;
    ArrayList<ExtraDetail> extraDetails;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayRank() {
        return displayRank;
    }

    public void setDisplayRank(String displayRank) {
        this.displayRank = displayRank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ArrayList<ExtraDetail> getExtraDetails() {
        return extraDetails;
    }

    public void setExtraDetails(ArrayList<ExtraDetail> extraDetails) {
        this.extraDetails = extraDetails;
    }

    @Override
    public String TableName() {
        return "SpecialExtraList";
    }
}
