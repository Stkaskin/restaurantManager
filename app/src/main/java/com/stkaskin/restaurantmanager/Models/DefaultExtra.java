package com.stkaskin.restaurantmanager.Models;

public class DefaultExtra {
    String extraId;
    boolean defaultValue=false;

    public String getExtraId() {
        return extraId;
    }

    public void setExtraId(String extra) {
        this.extraId = extra;
    }

    public boolean isDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(boolean defaultValue) {
        this.defaultValue = defaultValue;
    }
}
