package com.stkaskin.restaurantmanager.Models;

import com.stkaskin.restaurantmanager.FireCloud.IFirebase;

import java.util.ArrayList;

public class PersonType implements IFirebase {    String id;
    String SpecialPersonTypeListid;
    boolean CategoryAdd;
    boolean CategoryDelete;
    boolean booleanCategoryUpdate;
    boolean OrderAdd;
    boolean OrderDelete;
    boolean OrderUpdate;
    boolean PersonAdd;
    boolean PersonDelete;
    boolean PersonUpdate;
    boolean ProductAdd;
    boolean ProductDelete;
    boolean ProductUpdate;

    boolean TableAdd;
    boolean TableDelete;
    boolean TableUpdate;
    boolean TypeAdd;
    boolean TypeDelete;
    boolean TypeUpdate;
    ArrayList<Person> personList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpecialPersonTypeListid() {
        return SpecialPersonTypeListid;
    }

    public void setSpecialPersonTypeListid(String specialPersonTypeListid) {
        SpecialPersonTypeListid = specialPersonTypeListid;
    }

    public boolean isCategoryAdd() {
        return CategoryAdd;
    }

    public void setCategoryAdd(boolean categoryAdd) {
        CategoryAdd = categoryAdd;
    }

    public boolean isCategoryDelete() {
        return CategoryDelete;
    }

    public void setCategoryDelete(boolean categoryDelete) {
        CategoryDelete = categoryDelete;
    }

    public boolean isBooleanCategoryUpdate() {
        return booleanCategoryUpdate;
    }

    public void setBooleanCategoryUpdate(boolean booleanCategoryUpdate) {
        this.booleanCategoryUpdate = booleanCategoryUpdate;
    }

    public boolean isOrderAdd() {
        return OrderAdd;
    }

    public void setOrderAdd(boolean orderAdd) {
        OrderAdd = orderAdd;
    }

    public boolean isOrderDelete() {
        return OrderDelete;
    }

    public void setOrderDelete(boolean orderDelete) {
        OrderDelete = orderDelete;
    }

    public boolean isOrderUpdate() {
        return OrderUpdate;
    }

    public void setOrderUpdate(boolean orderUpdate) {
        OrderUpdate = orderUpdate;
    }

    public boolean isPersonAdd() {
        return PersonAdd;
    }

    public void setPersonAdd(boolean personAdd) {
        PersonAdd = personAdd;
    }

    public boolean isPersonDelete() {
        return PersonDelete;
    }

    public void setPersonDelete(boolean personDelete) {
        PersonDelete = personDelete;
    }

    public boolean isPersonUpdate() {
        return PersonUpdate;
    }

    public void setPersonUpdate(boolean personUpdate) {
        PersonUpdate = personUpdate;
    }

    public boolean isProductAdd() {
        return ProductAdd;
    }

    public void setProductAdd(boolean productAdd) {
        ProductAdd = productAdd;
    }

    public boolean isProductDelete() {
        return ProductDelete;
    }

    public void setProductDelete(boolean productDelete) {
        ProductDelete = productDelete;
    }

    public boolean isProductUpdate() {
        return ProductUpdate;
    }

    public void setProductUpdate(boolean productUpdate) {
        ProductUpdate = productUpdate;
    }

    public boolean isTableAdd() {
        return TableAdd;
    }

    public void setTableAdd(boolean tableAdd) {
        TableAdd = tableAdd;
    }

    public boolean isTableDelete() {
        return TableDelete;
    }

    public void setTableDelete(boolean tableDelete) {
        TableDelete = tableDelete;
    }

    public boolean isTableUpdate() {
        return TableUpdate;
    }

    public void setTableUpdate(boolean tableUpdate) {
        TableUpdate = tableUpdate;
    }

    public boolean isTypeAdd() {
        return TypeAdd;
    }

    public void setTypeAdd(boolean typeAdd) {
        TypeAdd = typeAdd;
    }

    public boolean isTypeDelete() {
        return TypeDelete;
    }

    public void setTypeDelete(boolean typeDelete) {
        TypeDelete = typeDelete;
    }

    public boolean isTypeUpdate() {
        return TypeUpdate;
    }

    public void setTypeUpdate(boolean typeUpdate) {
        TypeUpdate = typeUpdate;
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }

    @Override
    public String TableName() {
        return "PersonType";
    }
}
