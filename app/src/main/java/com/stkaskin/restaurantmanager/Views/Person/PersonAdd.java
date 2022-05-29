package com.stkaskin.restaurantmanager.Views.Person;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.Person;
import com.stkaskin.restaurantmanager.R;

public class PersonAdd extends AppCompatActivity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_add);

    }
    public void Add(View view)
    {

        EditText name = findViewById(R.id.txt_personadd_name);

        String name_temp = name.getText().toString();
        Person person = new Person();
        person.setName(name_temp);
        person.setDisplayRank(1);
        person.setStatus(1);
        //specialpersontypelist e gidilecek ve seçilenin typeid si çekilecek
        person.setType("B5cIFcOFjonE0FQUidVx");
        person.setImageid("");
        String id = FirebaseService.AddData(person);
        Toast.makeText(this, "Eklendi : " + id, Toast.LENGTH_SHORT).show();
    }




}