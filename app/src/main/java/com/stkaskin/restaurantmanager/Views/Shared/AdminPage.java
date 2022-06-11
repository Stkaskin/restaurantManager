package com.stkaskin.restaurantmanager.Views.Shared;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.stkaskin.restaurantmanager.Models.Person;
import com.stkaskin.restaurantmanager.Views.Listeler.ActiveOrders;
import com.stkaskin.restaurantmanager.Views.Listeler.CategoryList;
import com.stkaskin.restaurantmanager.Views.Listeler.ExtraList;
import com.stkaskin.restaurantmanager.Views.Listeler.PersonList;
import com.stkaskin.restaurantmanager.Views.Listeler.ProductList;
import com.stkaskin.restaurantmanager.R;
import com.stkaskin.restaurantmanager.Views.Listeler.TableList_A;
import com.stkaskin.restaurantmanager.Views.Person.PersonAdd;
import com.stkaskin.restaurantmanager.Views.Table.TableList;

public class AdminPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);
    }

    public void categoryOpen(View view) {
        Intent intent = new Intent(this, CategoryList.class);
        startActivity(intent);

    }

    public void productOpen(View view) {
        Intent intent = new Intent(this, ProductList.class);
        startActivity(intent);

    }

    public void extraOpen(View view) {
        Intent intent = new Intent(this, ExtraList.class);
        startActivity(intent);

    }

    public void tableOpen(View view) {
        Intent intent = new Intent(this, TableList_A.class);
        startActivity(intent);

    }

    public void personOpen(View view) {
        Intent intent = new Intent(this, PersonList.class);
        startActivity(intent);

    }

    public void orderOpen(View view) {
        Intent intent = new Intent(this, ActiveOrders.class);
        startActivity(intent);
    }


}