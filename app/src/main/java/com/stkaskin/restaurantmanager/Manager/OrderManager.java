package com.stkaskin.restaurantmanager.Manager;

import android.widget.TextView;

import com.stkaskin.restaurantmanager.Models.Order;
import com.stkaskin.restaurantmanager.Models.Person;
import com.stkaskin.restaurantmanager.Models.Product;

import java.util.ArrayList;

public class OrderManager {

    public ArrayList<Order> getOrders() {
        return addAllOrders();
    }

    public Order setOrder(Order order, Order setOrder) {
        return setOrderProperties(order, setOrder);
    }


    public ArrayList<Order> setAllOrders(ArrayList<Order> orders) {
        ArrayList<Order> list = getOrders();
        for (int y = 0; y < orders.size(); y++)
            for (int i = 0; i < list.size(); i++)
                if (list.get(i).getId() == orders.get(y).getId())
                    list.set(i, setOrderProperties(list.get(i), orders.get(y)));
        return list;
    }

    public Order setOrderProperties(Order order, Order setOrder) {
        order = setOrder;
        return order;
    }

    //int id, int personId, int productId, int tableId, Product product, Person person, Table table
    private ArrayList<Order> addAllOrders() {
        ArrayList<Order> orders = new ArrayList<>();
        //veritabanı
        orders.add(addOrder(1,2,1,2));
        orders.add(addOrder(2,2,1,3));
        orders.add(addOrder(3,7,2,1));

        return orders;
    }

    private Order addOrder( int id,int productid, int personid,
                           int tableid) {
        return new Order(
                id, personid, productid, tableid,
                new ProductManager().getProduct(productid),
                new PersonManager().getPerson(personid),
                new TableManager().getTable(tableid));
    }
    public void infoOrder(int id,TextView view)
    {

        //order id personad, masasının adı,category adı,ürünün adı
        view.setText("");
        for (Order order:getOrders()) {
            if (order.getId()==id)
                  view.append(order.getPerson().getName()+" "+order.getTable().getAd()+" "+order.getProduct().getCategory().getName()+" "+order.getProduct().getName());
        }
    }
}
