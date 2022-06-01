package com.stkaskin.restaurantmanager;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.Table;
import com.stkaskin.restaurantmanager.Views.Category.CategoryAdd;
import com.stkaskin.restaurantmanager.Views.Login;
import com.stkaskin.restaurantmanager.Views.Order.OrderCategoryList;
import com.stkaskin.restaurantmanager.Views.Person.PersonAdd;
import com.stkaskin.restaurantmanager.Views.Person.PersonList;
import com.stkaskin.restaurantmanager.Views.Product.Product_Add;
import com.stkaskin.restaurantmanager.Views.Table.TableAdd;
import com.stkaskin.restaurantmanager.Views.Table.TableList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Veritabanı bağlantısı başlatılıyor region Basladi
        Table table = new Table();
        table.setId("79JdwyQ9WCWwRI7pY23N");
        FirebaseService.ReadData(table);
        // endregion Basladi
        Intent i = new Intent(getApplicationContext(), OrderCategoryList.class);
        startActivity(i);
        //ArrayList<Table> Tables= FirebaseService.ReadData(new Table());
        //     Object obj=  FirebaseService.SearchCustom(new Table(),FirebaseService.QueryCustom(new Table()).whereEqualTo("name","S-30"));
        ///Object obj1=FirebaseService.ReadDataWhereDocumentId(obj,"79JdwyQ9WCWwRI7pY23N");
    }

}