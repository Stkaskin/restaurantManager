package com.stkaskin.restaurantmanager.Models;

import com.google.android.material.tabs.TabLayout;

public class Table {
    int id;
    String  ad;
   public  Table(){}
   public  Table(int id,String ad)
   {
       this.id=id;
       this.ad=ad;
   }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }
}
