package com.stkaskin.restaurantmanager.Views.Product;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;

import com.stkaskin.restaurantmanager.Models.Product;
import com.stkaskin.restaurantmanager.R;

public class Product_Add extends AppCompatActivity {
    Spinner spinnerCategory, spinnerDurum;
    ArrayAdapter<String> adapterCategory, adapterDurum;
    String[] Category = {"Select", "Main", "Drinks", "Soups"};
    String[] Durum = {"var", "yok"};//veri tabanından gelicek
    ImageView imageView;
    int izinVerildi=1, izinReddedildi =0;
    ActivityResultLauncher<String> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_add);
        spinnerCategory = findViewById(R.id.spinnerCategory);
        imageView = findViewById(R.id.imageViewFotoEkle);
        spinnerDurum = findViewById(R.id.spinnerDurumProduct);


        adapterCategory = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Category);
        adapterDurum = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Durum);
        adapterCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterDurum.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapterCategory);
        spinnerDurum.setAdapter(adapterDurum);

        //galeriden foto alma
        launcher = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {
                imageView.setImageURI(result);
            }
        });


    }

    //galeriden foto alma
    public void resimSec(View view) {

        imageView.setOnClickListener( view1 -> launcher.launch("image/*"));



        /* if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},izinReddedildi);
        }
        else {
            Intent resimAl = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            onActivityResult(izinVerildi,0,resimAl);
        }*/
    }


    public void Add(View view) {

        EditText name = findViewById(R.id.txt_productadd_name);
        // EditText des = findViewById(R.id.txt_productadd_description);
        //Listeler cekilecek spinner icine eklenecek

        String name_temp = name.getText().toString();
        Product product = new Product();
        product.setName(name_temp);
        product.setDisplayRank(1);
        product.setStatus(1);
        //product.setDescription(des.getText().toString());

        //product.setExtraSpeacialListId("dEm7mqDz9ULbDHeKHqns");
        //product.setCategoryId("JpvTAXiQzDz7UzEPY1AG");
        //product.setImageid("");


        String id = FirebaseService.Add(product);
        Toast.makeText(this, "Eklendi : " + id, Toast.LENGTH_SHORT).show();
    }
}