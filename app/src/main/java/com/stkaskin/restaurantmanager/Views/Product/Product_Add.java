package com.stkaskin.restaurantmanager.Views.Product;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;

import com.stkaskin.restaurantmanager.Models.Product;
import com.stkaskin.restaurantmanager.R;

public class Product_Add extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_add);
    }
    public void Add(View view)
    {

        EditText name = findViewById(R.id.txt_productadd_name);
        EditText des = findViewById(R.id.txt_productadd_description);
        //Listeler cekilecek spinner icine eklenecek

        String name_temp = name.getText().toString();
        Product product = new Product();
        product.setName(name_temp);
        product.setDisplayRank(1);
        product.setStatus(1);
        product.setDescription(des.getText().toString());

        product.setExtraSpeacialListId("dEm7mqDz9ULbDHeKHqns");
        product.setCategoryId("JpvTAXiQzDz7UzEPY1AG");
        product.setImageid("");


        String id = FirebaseService.AddData(product);
        Toast.makeText(this, "Eklendi : " + id, Toast.LENGTH_SHORT).show();
    }
}