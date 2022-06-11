package com.stkaskin.restaurantmanager.Views.Table;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.Table;
import com.stkaskin.restaurantmanager.R;

public class TableAdd extends AppCompatActivity {

    ArrayAdapter<String> adapterTableDurum;
    String[] Durum = {"pasif", "aktif"};
    Spinner spinnerTableDurum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_add);
        spinnerTableDurum = findViewById(R.id.spinnerDurumTable);
        adapterTableDurum = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Durum);
        adapterTableDurum.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTableDurum.setAdapter(adapterTableDurum);


    }

    public void Add(View view) {


        EditText name = findViewById(R.id.txtTableName);

        String name_temp = name.getText().toString();

        Table table = new Table();
        table.setName(name_temp);
        String a__ = ((EditText) findViewById(R.id.editTextDisplayRankTable)).getText().toString();
        table.setDisplayRank(Integer.parseInt(a__));
        table.setStatus(spinnerTableDurum.getSelectedItemPosition());
        String id = FirebaseService.Add(table);
        Toast.makeText(this, "Eklendi : " + id, Toast.LENGTH_SHORT).show();

    }
}