package com.stkaskin.restaurantmanager.Views.Table;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.Table;
import com.stkaskin.restaurantmanager.Perdruable.Data;
import com.stkaskin.restaurantmanager.Perdruable.Page;
import com.stkaskin.restaurantmanager.Perdruable.UpdateData;
import com.stkaskin.restaurantmanager.R;
import com.stkaskin.restaurantmanager.Views.Listeler.ActiveOrders;
import com.stkaskin.restaurantmanager.Views.Login;
import com.stkaskin.restaurantmanager.Views.Order.OrderProductsList;
import com.stkaskin.restaurantmanager.Views.Shared.AdminPage;

import java.util.ArrayList;

import soup.neumorphism.NeumorphCardView;
import soup.neumorphism.ShapeType;

public class TableList extends AppCompatActivity implements View.OnClickListener {
    ArrayList<Table> tableArrayList = new ArrayList<>();
    LinearLayout layoutBack;
    int opertation = 1;
    ArrayList<Table> tables;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_list);

        UpdateData.contextid = 1;
        UpdateData.tableUpdate = false;
        this.opertation = getIntent().getIntExtra("operation", 0);
        //  üst tarafa yetkisi varsa uzun basıldıgında
        //  silme ve güncelleme komutları olacak
        //üst tarafa + buttonu eklenecek yetkililer için
        layoutBack = findViewById(R.id.linearLayoutTables);
        LinearLayout row = new LinearLayout(this);
        Button button;
        //yetkisi varsa





        // GetTableDynamic(tables);

        ArrayList<Table> table_temp = FirebaseService.Get(Table.class);
        //  ArrayList<Table> table_temp=new ArrayList<>();
        tables = Sort(table_temp);
        GetTableDynamic(tables);


    }

    private LinearLayout getAddButton(LinearLayout layoutBack) {
        LinearLayout row = new LinearLayout(this);
        Button button = new Button(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                120
        );
        row.setOrientation(LinearLayout.HORIZONTAL);
        params.setMargins(0, 20, 20, 20);

        button.setBackgroundResource(R.drawable.plusbutton);
        button.setOnClickListener(
                view -> {
                    Intent i=new Intent(this, AdminPage.class);
                    Data.giris=0;
                    startActivity(i);
                }
        );
        button.setLayoutParams(new ViewGroup.LayoutParams(200, ViewGroup.LayoutParams.MATCH_PARENT));

        button.setText("ADMİN");
        row.setLayoutParams(params);
        row.addView(button);
        button = new Button(this);


        button.setBackgroundResource(R.drawable.plusbutton);
        button.setOnClickListener(
                view -> {
                    Intent i=new Intent(this, AdminPage.class);
                    Data.giris=2;
                    startActivity(i);
                }
        );
        button.setText("Waiter");
        button.setLayoutParams(new ViewGroup.LayoutParams(200, ViewGroup.LayoutParams.MATCH_PARENT));

        row.addView(button);
        button = new Button(this);
        button.setBackgroundResource(R.drawable.plusbutton);
        button.setOnClickListener(
                view -> {
                    Intent i=new Intent(this, ActiveOrders.class);
                    Data.giris=1;
                    startActivity(i);
                }
        );

        button.setLayoutParams(new ViewGroup.LayoutParams(200, ViewGroup.LayoutParams.MATCH_PARENT));

        row.addView(button);
        button.setText("Cheff");

        button = new Button(this);
        button.setBackgroundResource(R.drawable.plusbutton);
        button.setOnClickListener(
                view -> {
                    Intent i=new Intent(this, Login.class);
                    Data.giris=-1;
                    startActivity(i);
                }
        );

        button.setLayoutParams(new ViewGroup.LayoutParams(200, ViewGroup.LayoutParams.MATCH_PARENT));
        row.addView(button);
        button.setText("Login");

        layoutBack.addView(row);


        return layoutBack;

    }


    private void GetTableDynamic(ArrayList<Table> tables) {


        layoutBack.removeAllViews();
        layoutBack = getAddButton(layoutBack);
        NeumorphCardView button = new NeumorphCardView(this);
        LinearLayout row = new LinearLayout(this);
        for (int i = 0; i < tables.size(); i++) {

            if (i % 3 == 0) {
                row = new LinearLayout(this);
                row.setOrientation(LinearLayout.HORIZONTAL);
                layoutBack.addView(row);
            }

            button = new NeumorphCardView(this);
            //  button.setText(tables.get(i).getName());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT, Gravity.CENTER
            );


            button.setShapeType(ShapeType.FLAT);

            TextView textView = new TextView(this);
            textView.setText(tables.get(i).getName() + "");
            textView.setGravity(Gravity.CENTER);


            button.addView(textView);
            params.setMargins(5, 5, 5, 5);
            params.width = 350;
            params.height = 350;
            button.setId(i);
            button.setTag(tables.get(i));

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
        Table table = (Table) v.getTag();
        String mesaj = table.getName();
        if (table.getStatus() == 0) {
            mesaj += " Sipariş Oluşturma.";

        } else if (table.getStatus() == 1)
            mesaj += " Sipariş Güncelleme";
        else
            mesaj += " Masa Hazırlık Aşamasında";
        Toast.makeText(this, mesaj + " \nid=" + table.getId(), Toast.LENGTH_SHORT).show();

        Intent m = new Intent(this, OrderProductsList.class);
        Page.IntentGet(m);
        m.putExtra("operation", 1);
        m.putExtra("idTable", table.getId());
        startActivityForResult(m, 1);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (UpdateData.tableUpdate) {
            ArrayList<Table> table_temp = FirebaseService.Get(Table.class);
            //  ArrayList<Table> table_temp=new ArrayList<>();
            tables = Sort(table_temp);
            GetTableDynamic(tables);
            UpdateData.tableUpdate = false;
        }


    }

    //generic algoritma olacak
    private ArrayList<Table> Sort(ArrayList<Table> table_temp) {
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
        return tables;
    }
}