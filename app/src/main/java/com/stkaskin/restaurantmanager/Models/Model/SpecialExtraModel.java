package com.stkaskin.restaurantmanager.Models.Model;

import com.stkaskin.restaurantmanager.Models.Extra;

public class SpecialExtraModel {
    Extra extra=new Extra();
    boolean value=false;

    public Extra getExtra() {
        return extra;
    }

    public void setExtra(Extra extra) {
        this.extra = extra;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
}
