package com.stkaskin.restaurantmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.stkaskin.restaurantmanager.Manager.OrderManager;
import com.stkaskin.restaurantmanager.Manager.TableManager;
import com.stkaskin.restaurantmanager.Models.Table;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ArrayList liste=Dataeleman.getArrayListElemanlar();
        TextView new_tw = findViewById(R.id.newTextView);
        TextView old_tw = findViewById(R.id.oldTextView);
        TableManager manager = new TableManager();
        ArrayList<Table> tables = manager.getTables();
       /* old_tw.setText("");
        for (int i = 0; i < tables.size(); i++) {
            old_tw.append("id: "+tables.get(i).getId()+" ad: "+tables.get(i).getAd()+"\n");
        }


        Table first=tables.get(0);
        first.setAd("BUNDLE");
          tables=manager.setAllTables(tables);
        new_tw.setText("");
        for (int i = 0; i < tables.size(); i++) {
            new_tw.append("id: "+tables.get(i).getId()+" ad: "+tables.get(i).getAd()+"\n");
        }
*/
        new OrderManager().infoOrder(1,new_tw);
        //  v.setText(garson.Add());


    }
}