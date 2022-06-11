package com.stkaskin.restaurantmanager.Views.Listeler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Toast;

import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.Extra;
import com.stkaskin.restaurantmanager.R;
import com.stkaskin.restaurantmanager.Views.Category.CategoryAdd;
import com.stkaskin.restaurantmanager.Views.Extra.ExtraAdd;
import com.stkaskin.restaurantmanager.Widgets.ListWidget;

import java.util.ArrayList;

public class ExtraList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra_list);
        ScrollView l = findViewById(R.id.extraListLinearScroll);
        ListWidget.marginScrollView(l);
        ArrayList<Extra> extras = FirebaseService.Get(Extra.class);
        for (Extra ct : extras)
            ListWidget.listWidget(
                    findViewById(R.id.extraListLinear), ct.getId(), ct.getName(), ct,
                    view -> edit(view), view -> delete(view));
    }
    public void add(View view) {
    }

    public void delete(View view) {
        Extra ct = (Extra) view.getTag();
        Toast.makeText(this, ct.getId(), Toast.LENGTH_SHORT).show();
    }

    public void edit(View view) {
        Extra  ct = (Extra) view.getTag();
        Toast.makeText(this, "edit   " + ct.getId(), Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this, ExtraAdd.class);
        intent.putExtra("operation",1);
        intent.putExtra("extraId",ct.getId());
        startActivity(intent);
    }
    public void back(View view)
    {
        finish();
    }
    public void addNew(View view)
    {
        Intent intent=new Intent(this, ExtraAdd.class);
        intent.putExtra("operation",0);
        startActivity(intent);

    }

}