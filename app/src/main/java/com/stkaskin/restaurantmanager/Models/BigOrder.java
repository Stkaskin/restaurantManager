package com.stkaskin.restaurantmanager.Models;

import com.stkaskin.restaurantmanager.FireCloud.IFirebase;

import java.util.ArrayList;

public class BigOrder implements IFirebase {
    String id;

    String cheffId;
    String datetime;
    String note;
    int status=0;
    String tableId;
    int total=0;
    String waiterId;
    ArrayList<detailOrder> orders = new ArrayList<>();

    public String getId() {
        return id;
    }

    @Override
    public String TableName() {
        return "BigOrder";
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getCheffId() {
        return cheffId;
    }

    public void setCheffId(String cheffId) {
        this.cheffId = cheffId;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;

    }

    public String getWaiterId() {
        return waiterId;
    }

    public void setWaiterId(String waiterId) {
        this.waiterId = waiterId;
    }

    public ArrayList<detailOrder> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<detailOrder> orders) {
        this.orders = orders;
        int s=0;
        for (detailOrder d:orders) {
            s+=d.getSum();
        }
        this.total=s;
    }
}
