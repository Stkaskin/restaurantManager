package com.stkaskin.restaurantmanager.Views.Table;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.Table;
import com.stkaskin.restaurantmanager.R;

public class TableAdd extends AppCompatActivity {

    //  ArrayAdapter<String> adapterTableDurum;
    //  String[] Durum = {"pasif", "aktif"};
    //    Spinner spinnerTableDurum;
    Table table = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_add);
        //  spinnerTableDurum = findViewById(R.id.spinnerDurumTable);
        //  adapterTableDurum = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Durum);
        //      adapterTableDurum.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //  spinnerTableDurum.setAdapter(adapterTableDurum);

        int getextra = getIntent().getIntExtra("operation", 0);
        if (getextra == 1) {
            TextView tx = findViewById(R.id.textView8);
            tx.setText("Edit Table");
            String id = getIntent().getStringExtra("tableId");
            table = FirebaseService.Get(Table.class, id);
            EditText text = findViewById(R.id.txtTableName);
            text.setText(table.getName());
        }


    }

    public void Add(View view) {
        boolean add = false;
        if (table == null) {
            add = true;
            table = new Table();

        }
        EditText name = findViewById(R.id.txtTableName);
        String name_temp = name.getText().toString();
        table.setName(name_temp);
        if (add) {
            table.setStatus(0);
            String id = FirebaseService.Add(table);
        } else {
            FirebaseService.UpdateData(table);
        }
        finish();
    }
}