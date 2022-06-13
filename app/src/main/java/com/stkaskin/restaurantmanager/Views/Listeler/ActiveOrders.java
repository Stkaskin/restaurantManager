package com.stkaskin.restaurantmanager.Views.Listeler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.Query;
import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.BigOrder;
import com.stkaskin.restaurantmanager.Perdruable.Data;
import com.stkaskin.restaurantmanager.R;
import com.stkaskin.restaurantmanager.Views.Table.TableAdd;
import com.stkaskin.restaurantmanager.Widgets.AlerDialogWidget;
import com.stkaskin.restaurantmanager.Widgets.ListWidget;

import java.util.ArrayList;

public class ActiveOrders extends AppCompatActivity {
    int s = 1;
Query query=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_orders);
        ScrollView l = findViewById(R.id.orderListLinearScroll);
        ListWidget.marginScrollView(l);
        AlerDialogWidget.title=AlerDialogWidget.default_title;
        AlerDialogWidget.description=AlerDialogWidget.default_description;
        AlerDialogWidget.yes_=AlerDialogWidget.default_yes;
        AlerDialogWidget.no_=AlerDialogWidget.default_no;
        if (Data.giris == 0) {
            ListWidget.permissionedit = false;
            ListWidget.permissiondelete = true;



        } else if (Data.giris == 1) {
            AlerDialogWidget.title="Siparişi Onayla";
            AlerDialogWidget.description="Siparişi Hazırladığınıza Emin Misiniz?";
            AlerDialogWidget.yes_="Onayla";
            AlerDialogWidget.no_="İptal";
            ListWidget.permissionedit = false;
            ListWidget.permissiondelete = true;
            ListWidget.icon=ListWidget.update_;
            query=FirebaseService.QueryCreate(BigOrder.class).
                    whereEqualTo("status", 0);




        } else {

            AlerDialogWidget.title="Siparişi Al";
            AlerDialogWidget.description="Siparişi Aldınız Mı?";
            AlerDialogWidget.yes_="Aldım";
            AlerDialogWidget.no_="İptal";
            ListWidget.permissionedit = false;
            ListWidget.permissiondelete = false;
            query=FirebaseService.QueryCreate(BigOrder.class).
                    whereEqualTo("status", 1);


        }
        find(query);
        ListWidget.icon=ListWidget.defaults_;
        ListWidget.permissionedit = true;
        ListWidget.permissiondelete = true;


    }

    public void find(Query query) {
        LinearLayout layout = findViewById(R.id.orderListLinear);
        layout.removeAllViews();
        ArrayList<BigOrder> bigOrders = null;
        if (query == null)
            bigOrders = FirebaseService.Get(BigOrder.class);
        else
            bigOrders = FirebaseService.Get(BigOrder.class, query);
        for (BigOrder ct : bigOrders)
            ListWidget.listWidget(
                    layout, ct.getId(), ct.getDatetime(), ct,
                    view -> edit(view), view -> delete(view));
    }


    public void delete(View view) {
        BigOrder ct = (BigOrder) view.getTag();
        AlerDialogWidget.aa(this, (dialogInterface, i) ->
                {
                    if (s == 0) {
                        ct.setStatus(3);
                        FirebaseService.Delete(ct);
                        Toast.makeText(this, "Bitti" +
                                ct.getId(), Toast.LENGTH_SHORT).show();
                    } else if (s == 1) {
                        ct.setStatus(1);
                        FirebaseService.UpdateData(ct);
                        find(query);
                    }
                }
                , (dialogInterface, i) -> {
                    dialogInterface.cancel();
                });
    }

    public void edit(View view) {
        BigOrder ct = (BigOrder) view.getTag();
        Toast.makeText(this, "edit   " + ct.getId(), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, TableAdd.class);
        //intent.putExtra("operation", 1);
       // intent.putExtra("tableId", ct.getId());
    //    startActivity(intent);

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