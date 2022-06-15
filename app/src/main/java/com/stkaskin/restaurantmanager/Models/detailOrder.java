package com.stkaskin.restaurantmanager.Models;

import java.util.ArrayList;

public class detailOrder {
    String productId;
    int count=1;
    int price=0;
    int sum=0;
    ArrayList<ExtraProduct> extras=new ArrayList<>();

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
        setSum(this.price);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
        setSum(this.price);
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;

    }

    public ArrayList<ExtraProduct> getExtras() {
        return extras;
    }

    public void setExtras(ArrayList<ExtraProduct> extras) {
        this.extras = extras;
    }
}
