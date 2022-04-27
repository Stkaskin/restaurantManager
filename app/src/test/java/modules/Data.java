package modules;

import java.util.ArrayList;

public class Data {
    static  String garson ="Garson";
    static  String asci = "Aşçı";
    static  String mudur = "Müdür";


  static   public ArrayList<String> getArrayListElemanlar() {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add(garson);
        arrayList.add(asci);
        arrayList.add(mudur);
        return arrayList;

    }

}
