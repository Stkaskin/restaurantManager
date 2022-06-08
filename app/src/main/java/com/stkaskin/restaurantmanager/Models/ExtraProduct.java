package com.stkaskin.restaurantmanager.Models;

public class ExtraProduct {
    boolean select;
    String extraid;
    String grpName;

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public String getExtraid() {
        return extraid;
    }

    public void setExtraid(String extraid) {
        this.extraid = extraid;
    }

    public String getGrpName() {
        return grpName;
    }

    public void setGrpName(String grpName) {
        this.grpName = grpName;
    }
}
