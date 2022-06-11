package com.stkaskin.restaurantmanager.Views.Listeler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.Table;
import com.stkaskin.restaurantmanager.R;
import com.stkaskin.restaurantmanager.Views.Table.TableAdd;
import com.stkaskin.restaurantmanager.Widgets.AlerDialogWidget;
import com.stkaskin.restaurantmanager.Widgets.ListWidget;

import java.util.ArrayList;

public class TableList_A extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_list2);
        ScrollView l = findViewById(R.id.tableListLinearScroll);
        ListWidget.marginScrollView(l);
        ArrayList<Table> tables = FirebaseService.Get(Table.class);
        for (Table ct : tables)
            ListWidget.listWidget(
                    findViewById(R.id.tableListLinear), ct.getId(), ct.getName(), ct,
                    view -> edit(view), view -> delete(view));
    }


    public void delete(View view) {
        Table ct = (Table) view.getTag();
        AlerDialogWidget.aa(this, (dialogInterface, i) ->
                {
                    FirebaseService.Delete(ct);
                    Toast.makeText(this, "Silindi" + ct.getId(), Toast.LENGTH_SHORT).show();

                }
                , (dialogInterface, i) -> {
                    dialogInterface.cancel();
                });
    }

    public void edit(View view) {
        Table ct = (Table) view.getTag();
        Toast.makeText(this, "edit   " + ct.getId(), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, TableAdd.class);
        intent.putExtra("operation", 1);
        intent.putExtra("tableId", ct.getId());
        startActivity(intent);

    }

    public void back(View view) {
        finish();
    }

    public void addNew(View view) {
        Intent intent = new Intent(this, TableAdd.class);
        intent.putExtra("operation", 0);
        startActivity(intent);
    }
}