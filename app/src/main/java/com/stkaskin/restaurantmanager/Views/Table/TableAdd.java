package com.stkaskin.restaurantmanager.Views.Table;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.Table;
import com.stkaskin.restaurantmanager.R;

public class TableAdd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_add);
    }

    public void Add(View view) {


        EditText name = findViewById(R.id.txt_tableadd_name);

        String name_temp = name.getText().toString();

        Table table = new Table();
        table.setName(name_temp);
        table.setDisplayRank(1);
        table.setStatus(1);
        String id = FirebaseService.Add(table);
        Toast.makeText(this, "Eklendi : " + id, Toast.LENGTH_SHORT).show();

    }
}