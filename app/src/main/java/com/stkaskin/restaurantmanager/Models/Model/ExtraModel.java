package com.stkaskin.restaurantmanager.Models.Model;

import java.util.ArrayList;

public class ExtraModel {
    String Header;
    ArrayList<ExtraAndDetailModel> models=new ArrayList<>();

    public String getHeader() {
        return Header;
    }

    public void setHeader(String header) {
        Header = header;
    }

    public ArrayList<ExtraAndDetailModel> getModels() {
        return models;
    }

    public void setModels(ArrayList<ExtraAndDetailModel> models) {
        this.models = models;
    }
}
