package com.stkaskin.restaurantmanager.Views.Listeler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.BigOrder;
import com.stkaskin.restaurantmanager.R;
import com.stkaskin.restaurantmanager.Views.Table.TableAdd;
import com.stkaskin.restaurantmanager.Widgets.AlerDialogWidget;
import com.stkaskin.restaurantmanager.Widgets.ListWidget;

import java.util.ArrayList;

public class ActiveOrders extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_orders);
        ScrollView l = findViewById(R.id.orderListLinearScroll);
        ListWidget.marginScrollView(l);
        ArrayList<BigOrder> bigOrders = FirebaseService.Get(BigOrder.class);
        for (BigOrder ct : bigOrders)
            ListWidget.listWidget(
                    findViewById(R.id.orderListLinear), ct.getId(), ct.getDatetime(), ct,
                    view -> edit(view), view -> delete(view));
    }


    public void delete(View view) {
        BigOrder ct = (BigOrder) view.getTag();
        AlerDialogWidget.aa(this, (dialogInterface, i) ->
                {
                    ct.setStatus(3);
                    FirebaseService.Delete(ct);
                    Toast.makeText(this, "Bitti" +
                            ct.getId(), Toast.LENGTH_SHORT).show();

                }
                , (dialogInterface, i) -> {
                    dialogInterface.cancel();
                });
    }

    public void edit(View view) {
        BigOrder ct = (BigOrder) view.getTag();
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