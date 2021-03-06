package com.stkaskin.restaurantmanager.Models;

import com.stkaskin.restaurantmanager.FireCloud.IFirebase;

import java.util.ArrayList;

public class Product implements IFirebase {
    String id;
    String categoryId;
    String description;
    int displayRank = 999;
    String imageid;
    String name;
    int status = 1;
    int price = 0;
    ArrayList<DefaultExtra> extras = new ArrayList<>();

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public ArrayList<DefaultExtra> getExtras() {
        return extras;
    }

    public void setExtras(ArrayList<DefaultExtra> extras) {
        this.extras = extras;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDisplayRank() {
        return displayRank;
    }

    public void setDisplayRank(int displayRank) {
        this.displayRank = displayRank;
    }


    public String getImageid() {
        return imageid;
    }

    public void setImageid(String imageid) {
        this.imageid = imageid;
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


    @Override
    public String TableName() {
        return "Product";
    }
}
