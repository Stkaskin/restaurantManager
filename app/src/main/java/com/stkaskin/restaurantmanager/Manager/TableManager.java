package com.stkaskin.restaurantmanager.Manager;
import com.stkaskin.restaurantmanager.Models.Product;
import com.stkaskin.restaurantmanager.Models.Table;

import java.util.ArrayList;

public class TableManager {

    public Table getTable(int id) {
        for (Table table:getTables())
            if (id==table.getId())
                return table;

        return null;
    }

    public ArrayList<Table> getTables() {
        return addAllTables();
    }

    public Table setTable(Table table, Table setData) {
        return setTableProperties(table, setData);
    }


    public ArrayList<Table> setAllTables(ArrayList<Table> tables) {
        ArrayList<Table> list = getTables();
        for (int y = 0; y < tables.size(); y++)
            for (int i = 0; i < list.size(); i++)
                if (list.get(i).getId() == tables.get(y).getId())
                    list.set(i, setTableProperties( list.get(i),tables.get(y)));
        return list;
    }
    public Table setTableProperties(Table table, Table setData) {
        table = setData;
      /*  table.setId(temp.getId());
        table.setAd(temp.getAd());*/
        return table;
    }
    private ArrayList<Table> addAllTables() {
        ArrayList<Table> tables = new ArrayList<>();
        //veritabanı
        tables.add(new Table(1, "KAT1"));
        tables.add(new Table(2, "KAT2"));
        tables.add(new Table(3, "KAT3"));
        return tables;
    }

}
