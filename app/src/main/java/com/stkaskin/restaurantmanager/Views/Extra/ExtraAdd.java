package com.stkaskin.restaurantmanager.Views.Extra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.Extra;
import com.stkaskin.restaurantmanager.Models.ExtraDetail;
import com.stkaskin.restaurantmanager.Models.Person;
import com.stkaskin.restaurantmanager.R;

public class ExtraAdd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra_add);
    }
    public void Add(View view)
    {

        EditText name = findViewById(R.id.txt_extraadd_name);

        String name_temp = name.getText().toString();
        Extra extra = new Extra();
        extra.setName(name_temp);
        //sayısal olarak tpye
        extra.setType(5);
        String id = FirebaseService.Add(extra);
        ExtraDetail detail =new ExtraDetail();

        detail.setName(name_temp);
        detail.setDisplayRank(1);
        detail.setStatus(1);
        detail.setExtraId(id);
        //hangi kategori altında görülecek
        detail.setSpecialExtraListId("GZnfnP3PN2XGfkpbgQD1");
        detail.setImageId("");
        String id2 = FirebaseService.Add(detail);
        Toast.makeText(this, "Eklendi : " + id+ "  ve "+id2, Toast.LENGTH_SHORT).show();
    }

}