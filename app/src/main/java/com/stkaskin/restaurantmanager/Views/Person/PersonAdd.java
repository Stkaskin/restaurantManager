package com.stkaskin.restaurantmanager.Views.Person;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.Person;
import com.stkaskin.restaurantmanager.R;

public class PersonAdd extends AppCompatActivity {

    Spinner spinnerStatu;
    ArrayAdapter<String> adapterStatu;
    String[] status = {"Select", "Admin", "Chef", "Waiter"};
    Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_add);
        spinnerStatu = findViewById(R.id.spinnerPersonType);
        adapterStatu = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, status);
        adapterStatu.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerStatu.setAdapter(adapterStatu);
        int getextra = getIntent().getIntExtra("operation", 0);
        if (getextra == 1) {
            TextView tx1 = findViewById(R.id.textView6);
            tx1.setText("Edit Person");
            String id = getIntent().getStringExtra("personId");
            person = FirebaseService.Get(Person.class, id);
            EditText tx = findViewById(R.id.txt_personadd_name);
            EditText tx2 = findViewById(R.id.txt_personadd_password);
            spinnerStatu.setSelection(person.getType() + 1);
            tx.setText(person.getName());
            tx2.setText(person.getPassword());

        }
    }

    public void Add(View view) {


        EditText name = findViewById(R.id.txt_personadd_name);
        EditText tx2 = findViewById(R.id.txt_personadd_password);
        String name_temp = name.getText().toString();
        boolean new_ = false;
        if (person == null) {
            person = new Person();
            new_ = true;
        }
        person.setName(name_temp);
        person.setPassword(tx2.getText().toString());
        person.setDisplayRank(Integer.parseInt(((EditText) findViewById(R.id.txt_personadd_password)).getText().toString()));
        person.setType(spinnerStatu.getSelectedItemPosition() - 1);
        if (new_)
            FirebaseService.Add(person);
        else
            FirebaseService.UpdateData(person);
        finish();

    }


}