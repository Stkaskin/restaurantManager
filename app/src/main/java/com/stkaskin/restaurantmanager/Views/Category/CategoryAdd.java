package com.stkaskin.restaurantmanager.Views.Category;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.Category;
import com.stkaskin.restaurantmanager.Models.Person;
import com.stkaskin.restaurantmanager.R;

public class CategoryAdd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_add);
    }
    public void Add(View view)
    {

        EditText name = findViewById(R.id.txt_categoryadd_name);
        Category category =new Category();
        String name_temp = name.getText().toString();

        category.setName(name_temp);
        category.setDisplayRank(1);
        category.setStatus(1);
        category.setImageid("");
        String id = FirebaseService.Add(category);
        Toast.makeText(this, "Eklendi : " + id, Toast.LENGTH_SHORT).show();
    }

}