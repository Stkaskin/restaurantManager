package com.stkaskin.restaurantmanager.Models.Model;

import android.widget.TextView;

import com.stkaskin.restaurantmanager.Models.Order;

import com.stkaskin.restaurantmanager.Models.Product;
import com.stkaskin.restaurantmanager.Models.Table;

import java.util.ArrayList;

public class OrderProductListModel {

    Table table;
    Order order;

    ArrayList<Product> products;
    TextView p1;
    TextView p2;
    TextView p3;

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }



    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }



    public TextView getP1() {
        return p1;
    }

    public void setP1(TextView p1) {
        this.p1 = p1;
    }

    public TextView getP2() {
        return p2;
    }

    public void setP2(TextView p2) {
        this.p2 = p2;
    }

    public TextView getP3() {
        return p3;
    }

    public void setP3(TextView p3) {
        this.p3 = p3;
    }
}
