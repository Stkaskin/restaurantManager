package com.stkaskin.restaurantmanager.Views.Extra;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.Extra;
import com.stkaskin.restaurantmanager.R;

public class ExtraAdd extends AppCompatActivity {
    ArrayAdapter<String> adapterCategoryDurum;
    String[] Durum = {"var", "yok"};
    Spinner spinnerDetailDurum;
    Extra extra = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra_add);


        adapterCategoryDurum = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Durum);
        adapterCategoryDurum.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        int getextra = getIntent().getIntExtra("operation", 0);

        if (getextra == 1) {
            String id = getIntent().getStringExtra("extraId");
            extra = FirebaseService.Get(Extra.class, id);
            EditText typ = findViewById(R.id.editTypeNo);
            EditText text = findViewById(R.id.txtExtraName);
            typ.setText(extra.getType() + "");
            text.setText(extra.getName());


        }

    }

    public void Add(View view) {

        EditText name = findViewById(R.id.txtExtraName);
        EditText no = findViewById(R.id.editTypeNo);

        String name_temp = name.getText().toString();

        if (extra == null) {
            extra = new Extra();
            extra.setName(name_temp);
            extra.setType(Integer.parseInt(no.getText().toString()));
            FirebaseService.Add(extra);
        } else {
            extra.setName(name_temp);
            extra.setType(Integer.parseInt(no.getText().toString()));
            FirebaseService.UpdateData(extra);

        }


    }

}