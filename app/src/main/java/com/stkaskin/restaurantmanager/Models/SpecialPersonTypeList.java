package com.stkaskin.restaurantmanager.Models;

import com.stkaskin.restaurantmanager.FireCloud.IFirebase;

public class SpecialPersonTypeList implements IFirebase {
    String id;
    String name;
    String persontypeid;
    PersonType type;

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

    public String getPersontypeid() {
        return persontypeid;
    }

    public void setPersontypeid(String persontypeid) {
        this.persontypeid = persontypeid;
    }

    public PersonType getType() {
        return type;
    }

    public void setType(PersonType type) {
        this.type = type;
    }

    @Override
    public String TableName() {
        return "SpecialPersonList";
    }
}
