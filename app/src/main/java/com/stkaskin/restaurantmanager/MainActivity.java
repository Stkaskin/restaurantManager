package com.stkaskin.restaurantmanager;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Manager.TableManager;
import com.stkaskin.restaurantmanager.Models.Category;
import com.stkaskin.restaurantmanager.Models.Person;
import com.stkaskin.restaurantmanager.Models.Table;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Category c = new Category();
        c.setDisplayRank(1);
        c.setStatus(1);
        c.setImageid("1");
        c.setName("Category1");

       // FirebaseService.AddData(c);
        TextView new_tw = findViewById(R.id.newTextView);
        new_tw.setText("Wait");



        // ArrayList liste=Dataeleman.getArrayListElemanlar();

        TextView old_tw = findViewById(R.id.oldTextView);

        TableManager manager = new TableManager();
        Table table=new Table();
        table.setName("P-23");
        table.setDisplayRank(1);
        table.setStatus(1);
       // FirebaseService.AddData(table);
        //  ArrayList<Table> Tables= FirebaseService.ReadData(new Table());
    }

    public void onComplete(@NonNull QuerySnapshot task,TextView new_tw) {

            for (DocumentSnapshot document : task.getDocuments()) {
                document.getId();
                new_tw.setText("Succes");  System.out.print("Succes");
            }

    }
}