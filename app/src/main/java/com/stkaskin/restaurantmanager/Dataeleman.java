package com.stkaskin.restaurantmanager;

import java.util.ArrayList;

public class Dataeleman {
    static  String garson ="Garson";
    static  String asci = "Aşçı";
    static  String mudur = "Müdür";


  static   public ArrayList<String> getArrayListElemanlar() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(garson);
        arrayList.add(asci);
        arrayList.add(mudur);
        return arrayList;

    }

}
