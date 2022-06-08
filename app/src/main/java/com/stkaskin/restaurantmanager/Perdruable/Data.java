package com.stkaskin.restaurantmanager.Perdruable;

import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.Category;
import com.stkaskin.restaurantmanager.Models.Product;
import com.stkaskin.restaurantmanager.Models.Table;

import java.util.ArrayList;

public class Data {
    public static ArrayList<Category> categories = new ArrayList<>();
    public  ArrayList<Table> tables = new ArrayList<>();
    public static Table table = new Table();
    public static Product product = new Product();
    public  void UpdateTables()
    {
       tables=  FirebaseService.Get(Table.class);
    }


}

