package com.stkaskin.restaurantmanager.Models;

import com.stkaskin.restaurantmanager.FireCloud.IFirebase;

public class Extra implements IFirebase {
    String id;
    String name;
    String type;

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

    public String getType() {
        return type+"";
    }

    public void setType(String type) {
        this.type = type+"";
    }



    @Override
    public String TableName() {
        return "Extra";
    }
}
