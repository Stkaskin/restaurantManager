package com.stkaskin.restaurantmanager.Manager;

import com.stkaskin.restaurantmanager.Interface.IManager;
import com.stkaskin.restaurantmanager.Models.Table;

import java.util.ArrayList;

public class TableManager implements IManager {


    public Table gets(String  id) {

        for (Table table : get())
            if (id.equals(table.getId()))
                return table;

        return null;
    }


    public ArrayList<Table> get() {
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

    public Table setTable(Table table, Table setData) {
        return setProperties(table, setData);
    }


    public ArrayList<Table> setAll(ArrayList<Table> tables) {
        ArrayList<Table> list = get();
        for (int y = 0; y < tables.size(); y++)
            for (int i = 0; i < list.size(); i++)
                if (list.get(i).getId() == tables.get(y).getId())
                    list.set(i, setProperties(list.get(i), tables.get(y)));
        return list;
    }

    public Table setProperties(Table table, Table setData) {
        table = setData;
      /*  table.setId(temp.getId());
        table.setAd(temp.getAd());*/
        return table;
    }

    public ArrayList<Table> addAll() {
        ArrayList<Table> tables = new ArrayList<>();
        //veritabanı
    /*    tables.add(new Table(1, "KAT1"));
        tables.add(new Table(2, "KAT2"));
        tables.add(new Table(3, "KAT3"));*/
        return tables;
    }

    @Override
    public Object setProperties(ArrayList<Object> list) {
        return null;
    }

}
