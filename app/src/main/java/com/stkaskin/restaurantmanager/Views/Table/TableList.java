package com.stkaskin.restaurantmanager.Views.Table;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.Table;
import com.stkaskin.restaurantmanager.R;

import java.util.ArrayList;

public class TableList extends AppCompatActivity implements View.OnClickListener {
    ArrayList<Table> tableArrayList = new ArrayList<>();
    LinearLayout layoutBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_list);
        //  üst tarafa yetkisi varsa uzun basıldıgında
        //  silme ve güncelleme komutları olacak
        //üst tarafa + buttonu eklenecek yetkililer için
        layoutBack = findViewById(R.id.linearLayoutTables);
        LinearLayout row = new LinearLayout(this);
        Button button ;
        Table table = new Table();
        table.setId("2FvjcVr4wwHi57Te0nbd");
        table.setDisplayRank(0);

        // FirebaseService.UpdateData(table);
        ArrayList<Table> table_temp = FirebaseService.Get(Table.class);
        ArrayList<Table> tables = new ArrayList<>();
        for (int c = 0; c < table_temp.size(); c++) {
            int tut = 0;
            for (int i = 0; i < table_temp.size(); i++) {
                if (table_temp.get(i).getDisplayRank() < table_temp.get(tut).getDisplayRank())
                    tut = i;
            }

            tables.add(table_temp.get(tut));
            table_temp.remove(tut);
            c--;


        }
        for (int i = 0; i < tables.size(); i++) {

            if (i % 3 == 0) {
                row = new LinearLayout(this);
                row.setOrientation(LinearLayout.HORIZONTAL);
                layoutBack.addView(row);
            }

            button = new Button(this);
            button.setText(tables.get(i).getName());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(5, 5, 5, 5);
            params.width = 350;
            params.height = 350;
            button.setId(i);
            button.setTag(i);

            button.setLayoutParams(params);
            if (tables.get(i).getStatus() == 0)
                button.setBackgroundColor(Color.GREEN);
            else if (tables.get(i).getStatus() == 1)
                button.setBackgroundColor(Color.RED);
            else
                button.setBackgroundColor(Color.YELLOW);


            button.setOnClickListener(TableList.this);
            row.addView(button);
            tableArrayList.add(tables.get(i));


        }


    }

    @Override
    public void onClick(View v) {

      //  Button button =findViewById((int) v.getTag());
        Table table = tableArrayList.get((int) v.getTag());
        String mesaj = table.getName();
        if (table.getStatus()==0)
            mesaj+=" boş";

       else if (table.getStatus()==1)
            mesaj+=" dolu";
       else
           mesaj+=" masa hazırlanıyor";
        Toast.makeText(this, mesaj, Toast.LENGTH_SHORT).show();

    }

}