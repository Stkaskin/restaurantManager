package com.stkaskin.restaurantmanager;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.Extra;
import com.stkaskin.restaurantmanager.Models.Table;
import com.stkaskin.restaurantmanager.Views.Order.OrderCategoryList;
import com.stkaskin.restaurantmanager.Views.Order.OrderCategoryProductsList;
import com.stkaskin.restaurantmanager.Views.Order.OrderProductsList;
import com.stkaskin.restaurantmanager.Views.Table.TableList;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Veritabanı bağlantısı başlatılıyor region Basladi
        //ArrayList<Table> tables = FirebaseService.Get(Table.class);
        Intent intent=new Intent(this, OrderCategoryProductsList.class );
        intent.putExtra("operation",1);
        startActivity(intent);
   //     Object obj = FirebaseService.Get(Table.class);

    }



}