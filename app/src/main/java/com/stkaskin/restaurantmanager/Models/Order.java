package com.stkaskin.restaurantmanager.Models;

import com.stkaskin.restaurantmanager.FireCloud.IFirebase;

import java.util.ArrayList;

public class Order implements IFirebase {
    String cheffId;
    String datetime;
    String id;
    String note;
    int status;
    String tableId;
    int total;
    String waiterId;
    String specialExtraListId;

    public String getSpecialExtraListId() {
        return specialExtraListId;
    }

    public void setSpecialExtraListId(String specialExtraListId) {
        this.specialExtraListId = specialExtraListId;
    }

    ArrayList<OrderDetail> orderDetailList;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return tableId.trim();
    }

    public void setTableId(String tableId) {
        this.tableId = tableId.trim();
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


    public ArrayList<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(ArrayList<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    @Override
    public String TableName() {
        return "Order";
    }
}
