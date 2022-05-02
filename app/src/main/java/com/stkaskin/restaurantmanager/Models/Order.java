package com.stkaskin.restaurantmanager.Models;
public class Order {
    int id;
    int personId;
    int productId;
    int tableId;
    Product product;
    Person person;
    Table table;

    public Order() {
    }

    public Order(int id, int personId, int productId, int tableId, Product product, Person person, Table table) {
        this.id = id;
        this.personId = personId;
        this.productId = productId;
        this.tableId = tableId;
        this.product = product;
        this.person = person;
        this.table = table;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getTableId() {

        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
}
