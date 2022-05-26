package com.stkaskin.restaurantmanager.Models;

import com.stkaskin.restaurantmanager.FireCloud.IFirebase;

public class Product implements IFirebase {    String id;
    String categoryId;
    String description;
    int displayRank;
    String extraSpeacialListId;
    String imageid;
    String name;
    int status;
    Category category;
    SpecialExtraList specialExtraList;

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

    public String getExtraSpeacialListId() {
        return extraSpeacialListId;
    }

    public void setExtraSpeacialListId(String extraSpeacialListId) {
        this.extraSpeacialListId = extraSpeacialListId;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public SpecialExtraList getSpecialExtraList() {
        return specialExtraList;
    }

    public void setSpecialExtraList(SpecialExtraList specialExtraList) {
        this.specialExtraList = specialExtraList;
    }

    @Override
    public String TableName() {
        return "Product";
    }
}
