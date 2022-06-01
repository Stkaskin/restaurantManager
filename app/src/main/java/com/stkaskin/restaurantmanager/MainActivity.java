package com.stkaskin.restaurantmanager;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.Table;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Veritabanı bağlantısı başlatılıyor region Basladi
        Table table = new Table();
        table.setStatus(1);
        table.setName("ttt2");
     //   String id = FirebaseService.Add(table);
        ArrayList<Table> tables = FirebaseService.Get(Table.class);
        // endregion Basladi
        Object obj = FirebaseService.Get(Table.class);

        // Intent i = new Intent(getApplicationContext(), PersonAdd.class);
        // startActivity(i);
        //ArrayList<Table> Tables= FirebaseService.ReadData(new Table());
        //     Object obj=  FirebaseService.SearchCustom(new Table(),FirebaseService.QueryCustom(new Table()).whereEqualTo("name","S-30"));
        ///Object obj1=FirebaseService.ReadDataWhereDocumentId(obj,"79JdwyQ9WCWwRI7pY23N");
    }

    public static <T> T documentIdSet(T obj, String data) {

        try {
            obj.getClass().getMethod("setId", String.class).invoke(obj, data);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return obj;


    }

}