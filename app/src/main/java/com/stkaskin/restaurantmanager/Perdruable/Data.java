package com.stkaskin.restaurantmanager.Perdruable;

import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.Category;
import com.stkaskin.restaurantmanager.Models.DefaultExtra;
import com.stkaskin.restaurantmanager.Models.Extra;
import com.stkaskin.restaurantmanager.Models.Product;
import com.stkaskin.restaurantmanager.Models.Table;

import java.util.ArrayList;

public class Data {
    public static ArrayList<Category> categories = new ArrayList<>();
    public  ArrayList<Table> tables = new ArrayList<>();
    public static int giris=-1;
    public static Table table = new Table();
    public static Product product = new Product();
    public static ArrayList<DefaultExtra>  selectedExtras = new ArrayList<>();
    public  void UpdateTables()
    {
       tables=  FirebaseService.Get(Table.class);
    }


}

