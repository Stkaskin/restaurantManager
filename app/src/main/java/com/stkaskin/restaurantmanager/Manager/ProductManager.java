package com.stkaskin.restaurantmanager.Manager;

import com.stkaskin.restaurantmanager.Interface.IManager;
import com.stkaskin.restaurantmanager.Models.Product;

import java.util.ArrayList;

public class ProductManager implements IManager {

    public Product get(String  id) {
        for (Product product : get())
            if (id == product.getId())
                return product;

        return null;
    }

    @Override
    public Object set(Object obj1_old, Object obj_set) {
        return null;
    }

    public ArrayList<Product> get() {
        return addAll();
    }

    public Product set(Product product, Product setproduct) {
        return setProperties(product, setproduct);
    }


    public ArrayList<Product> setAll(ArrayList<Product> products) {
        ArrayList<Product> list = get();
        for (int y = 0; y < products.size(); y++)
            for (int i = 0; i < list.size(); i++)
                if (list.get(i).getId() == products.get(y).getId())
                    list.set(i, setProperties(list.get(i), products.get(y)));
        return list;
    }

    public Product setProperties(Product product, Product setproduct) {
        product = setproduct;
      /*  product.setId(temp.getId());
        product.setAd(temp.getAd());*/
        return product;
    }

    public ArrayList<Product> addAll() {
        //veritabanı
        ArrayList<Product> products = new ArrayList<>();
      /*  products.add(new Product(1, "Ezo Gelin Çorbası", 1, new CategoryManger().search(1)));
        products.add(new Product(2, "Domates Çorbası", 1, new CategoryManger().search(1)));
        products.add(new Product(3, "Mercimek Çorbası", 1, new CategoryManger().search(1)));
        products.add(new Product(4, "Et Döner", 2, new CategoryManger().search(2)));
        products.add(new Product(5, "Tavuk Döner", 2, new CategoryManger().search(2)));
        products.add(new Product(6, "Kuru Fasulye", 2, new CategoryManger().search(2)));
        products.add(new Product(7, "Halka", 3, new CategoryManger().search(3)));
        products.add(new Product(8, "Şekerpare", 3, new CategoryManger().search(3)));
        products.add(new Product(9, "Puding", 3, new CategoryManger().search(3)));
        products.add(new Product(10, "Su", 4, new CategoryManger().search(4)));
        products.add(new Product(11, "Ayran", 4, new CategoryManger().search(4)));
        products.add(new Product(12, "Kola", 4, new CategoryManger().search(4)));*/
        return products;
    }

    @Override
    public Object setProperties(ArrayList<Object> list) {
        return null;
    }

    private ArrayList<Product> search(ArrayList<Product> list) {
        CategoryManager manager = new CategoryManager();

        for (int i = 0; i < list.size(); i++) {
           // list.get(i).setCategory(manager.search(list.get(i).getCategoryId()));
        }
        return list;
    }
}
