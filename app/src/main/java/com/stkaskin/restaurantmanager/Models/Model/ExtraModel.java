package com.stkaskin.restaurantmanager.Models.Model;

import com.stkaskin.restaurantmanager.Models.Extra;

import java.util.ArrayList;

public class ExtraModel {
    String header;
    ArrayList<SpecialExtraModel> extras;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public ArrayList<SpecialExtraModel> getExtras() {
        return extras;
    }

    public void setExtras(ArrayList<SpecialExtraModel> extras) {
        this.extras = extras;
    }
}
