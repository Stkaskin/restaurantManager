package com.stkaskin.restaurantmanager.Views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.Person;
import com.stkaskin.restaurantmanager.Perdruable.Data;
import com.stkaskin.restaurantmanager.R;
import com.stkaskin.restaurantmanager.Views.Listeler.ActiveOrders;
import com.stkaskin.restaurantmanager.Views.Shared.AdminPage;
import com.stkaskin.restaurantmanager.Views.Shared.Splash;
import com.stkaskin.restaurantmanager.Views.Table.TableList;

import java.util.ArrayList;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent intent = new Intent(this, Splash.class);
        startActivity(intent);

    }
    public void loginActive(View view){
        EditText name = findViewById(R.id.editTextTextPersonName);
        EditText pass = findViewById(R.id.editTextTextPersonName2);
        ArrayList<Person> person = FirebaseService.Get(Person.class,
                FirebaseService.QueryCreate(Person.class)
                        .whereEqualTo("name", name.getText().toString()).whereEqualTo("password", pass.getText().toString()));
        if (person != null && person.size() > 0) {
            if (person.get(0).getType() == 0) {
                Data.giris = 0;
                Intent intent1=new Intent(this, AdminPage.class);
                startActivity(intent1);
            }
            else if (person.get(0).getType() == 1)
            {
                Data.giris =1;
                Intent intent1=new Intent(this, ActiveOrders.class);
                startActivity(intent1);
            }
            else
            {
                Data.giris =2;
                Intent intent1=new Intent(this, TableList.class);
                startActivity(intent1);
            }
        }
    }
}