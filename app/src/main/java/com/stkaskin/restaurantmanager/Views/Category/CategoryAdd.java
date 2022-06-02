package com.stkaskin.restaurantmanager.Views.Category;

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
import com.stkaskin.restaurantmanager.Models.Category;
import com.stkaskin.restaurantmanager.Models.Person;
import com.stkaskin.restaurantmanager.R;

public class CategoryAdd extends AppCompatActivity {
    ImageView imageView;
    ActivityResultLauncher<String> launcher;
    ArrayAdapter<String> adapterCategoryDurum;
    String[] Durum = {"var", "yok"};
    Spinner spinnerCategoryDurum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_add);
        imageView = findViewById(R.id.imageViewFotoEkleCategory);
        spinnerCategoryDurum = findViewById(R.id.spinnerDurumCategory);

        launcher = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {
                imageView.setImageURI(result);
            }
        });


        adapterCategoryDurum = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Durum);
        adapterCategoryDurum.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategoryDurum.setAdapter(adapterCategoryDurum);



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
    public void resimSecCategory(View view) {

        imageView.setOnClickListener( view1 -> launcher.launch("image/*"));
    }

}