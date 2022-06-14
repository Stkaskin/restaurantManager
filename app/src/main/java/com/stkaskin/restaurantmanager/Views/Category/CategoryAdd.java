package com.stkaskin.restaurantmanager.Views.Category;

import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;
import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.Category;
import com.stkaskin.restaurantmanager.R;

public class CategoryAdd extends AppCompatActivity {
    ImageView imageView;
    ActivityResultLauncher<String> launcher;
    ArrayAdapter<String> adapterCategoryDurum;
    String[] Durum = {"var", "yok"};
    Spinner spinnerCategoryDurum;
    Uri uri = null;
    Category category = null;

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
                uri = result;
            }
        });


        adapterCategoryDurum = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Durum);
        adapterCategoryDurum.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategoryDurum.setAdapter(adapterCategoryDurum);
        int getextra = getIntent().getIntExtra("operation", 0);
        if (getextra == 1) {
            TextView tx1 = findViewById(R.id.textView5);
            tx1.setText("Edit Category");
            String id = getIntent().getStringExtra("categoryId");
            category = FirebaseService.Get(Category.class, id);
            //    spinnerCategoryDurum.setSelection(category.getStatus());
            EditText name = findViewById(R.id.txt_categoryadd_name);
            name.setText(category.getName());
            Task<Uri> t = FirebaseStorage.getInstance().getReference().child("images/"
                    + category.getId()).getDownloadUrl();

            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (t.isComplete()) {

                    if (t.isSuccessful()) {
                        Picasso.get().load(t.getResult()).into(imageView);
                        uri = t.getResult();
                    }
                    break;
                }
            }


        }
    }
    public void Add(View view) {
        EditText name = findViewById(R.id.txt_categoryadd_name);
        String name_temp = name.getText().toString();
        String id;
        if (category == null) {
            category = new Category();
            category.setName(name_temp);
            id = FirebaseService.Add(category);

        } else {

            category.setName(name_temp);
            id = category.getId();
            FirebaseService.UpdateData(category);
        }


        StorageReference ref = FirebaseStorage.getInstance().getReference().child("images/" + id+".png");
        UploadTask t = ref.putFile(uri);
        finish();

    }

    public void resimSecCategory(View view) {

        imageView.setOnClickListener(view1 -> launcher.launch("image/*"));
    }

}