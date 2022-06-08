package com.stkaskin.restaurantmanager.Views.Extra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.Extra;
import com.stkaskin.restaurantmanager.R;

public class ExtraAdd extends AppCompatActivity {
    ArrayAdapter<String> adapterCategoryDurum;
    String[] Durum = {"var", "yok"};
    Spinner spinnerDetailDurum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra_add);
        spinnerDetailDurum = findViewById(R.id.spinnerDurumExtra);




        adapterCategoryDurum = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Durum);
        adapterCategoryDurum.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDetailDurum.setAdapter(adapterCategoryDurum);


    }
    public void Add(View view)
    {

        EditText name = findViewById(R.id.txtExtraName);

        String name_temp = name.getText().toString();
        Extra extra = new Extra();
        extra.setName(name_temp);
        //sayısal olarak tpye
       // extra.setType(5);
      //  String id = FirebaseService.Add(extra);
  //      ExtraDetail detail =new ExtraDetail();


   /*     detail.setDisplayRank(1);
        detail.setStatus(1);
        detail.setExtraId(id);
        //hangi kategori altında görülecek
        detail.setSpecialExtraListId("GZnfnP3PN2XGfkpbgQD1");*/

//        String id2 = FirebaseService.Add(detail);
      //  Toast.makeText(this, "Eklendi : " + id+ "  ve "+id2, Toast.LENGTH_SHORT).show();
    }

}