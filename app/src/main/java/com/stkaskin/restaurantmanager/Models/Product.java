package com.stkaskin.restaurantmanager.Models;

public class Product {
 int id;
 String  name;
 int categoryId;
 Category category;
    public Product() {
    }

    public Product(int id, String name, int categoryId) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
    }
    public Product(int id, String name, int categoryId,Category category) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.category=category;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
