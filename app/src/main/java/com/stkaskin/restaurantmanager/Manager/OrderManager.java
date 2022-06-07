package com.stkaskin.restaurantmanager.Manager;

import android.widget.TextView;

import com.stkaskin.restaurantmanager.Interface.IManager;
import com.stkaskin.restaurantmanager.Models.Order;

import java.util.ArrayList;

public class OrderManager implements IManager {

    public ArrayList<Order> get() {
        return addAll();
    }

    @Override
    public Object get(String obj) {
        return null;
    }

    @Override
    public Object set(Object obj1_old, Object obj_set) {
        return null;
    }

    public Order set(Order order, Order setOrder) {
        return setProperties(order, setOrder);
    }


    public ArrayList<Order> setAll(ArrayList<Order> orders) {
        ArrayList<Order> list = get();
        for (int y = 0; y < orders.size(); y++)
            for (int i = 0; i < list.size(); i++)
                if (list.get(i).getId() == orders.get(y).getId())
                    list.set(i, setProperties(list.get(i), orders.get(y)));
        return list;
    }

    public Order setProperties(Order order, Order setOrder) {
        order = setOrder;
        return order;
    }

    //int id, int personId, int productId, int tableId, Product product, Person person, Table table
    public ArrayList<Order> addAll() {
        ArrayList<Order> orders = new ArrayList<>();
        //veritabanı
        orders.add(add("1", "2", "1", "2"));
        orders.add(add("2", "2", "1", "3"));
        orders.add(add("3", "7", "2", "1"));

        return orders;
    }

    @Override
    public Object setProperties(ArrayList<Object> list) {
        return null;
    }

    private Order add(String id, String productid, String personid,
                      String tableid) {
        /*
         new Order(
                id, personid, productid, tableid,
                new ProductManager().get(productid),
                new PersonManager().get(personid),
                new TableManager().get(tableid));
        * */
        return new Order();
    }

    public void info(String id, TextView view) {

        //order id personad, masasının adı,category adı,ürünün adı
        view.setText("");
        for (Order order : get()) {
         //   if (order.getId() == id)
          //      view.append(order.getWaiter().getName() + " " + order.getCheff().getName() + " ");
        }
    }
}
