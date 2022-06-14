package com.stkaskin.restaurantmanager.Views.Product;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
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
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;
import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.Category;
import com.stkaskin.restaurantmanager.Models.Product;
import com.stkaskin.restaurantmanager.Perdruable.Data;
import com.stkaskin.restaurantmanager.R;
import com.stkaskin.restaurantmanager.Views.Extra.ExtraSelectPage;

import java.util.ArrayList;

public class Product_Add extends AppCompatActivity {
    Spinner spinnerCategory, spinnerDurum;
    ArrayList<String> str = new ArrayList<>();
    ArrayAdapter<String> adapterCategory, adapterDurum;
    String[] Category = {"Select", "Main", "Drinks", "Soups"};
    String[] Durum = {"var", "yok"};//veri tabanından gelicek
    ImageView imageView;
    Uri uri = null;
    Product product = null;
    int izinVerildi = 1, izinReddedildi = 0;
    ActivityResultLauncher<String> launcher;
    ArrayList<com.stkaskin.restaurantmanager.Models.Category> categories;
    int getextra = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_add);
        spinnerCategory = findViewById(R.id.spinnerCategory);
        imageView = findViewById(R.id.imageViewFotoEkle);
        categories = FirebaseService.Get(com.stkaskin.restaurantmanager.Models.Category.class);


        for (Category ct : categories) {
            str.add(ct.getName());
        }
        adapterCategory = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, str);
        adapterDurum = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Durum);
        adapterCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterDurum.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapterCategory);


        //galeriden foto alma
        launcher = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {
                imageView.setImageURI(result);
                uri = result;
            }
        });


        getextra = getIntent().getIntExtra("operation", 0);
        if (getextra == 1) {
            TextView tx = findViewById(R.id.textView);
            tx.setText("Edit Product");
            String id = getIntent().getStringExtra("productId");
            product = FirebaseService.Get(Product.class, id);
            EditText text = findViewById(R.id.productaddprice);
            EditText name = findViewById(R.id.txt_productadd_name);
            spinnerCategory.setSelection(selectArrayItemFind());
            text.setText(product.getPrice() + "");
            name.setText(product.getName());
            imageOp();


        }
    }

    public int selectArrayItemFind() {
        int index = 0;
        for (Category category : categories) {
            if (category.getId().equals(product.getCategoryId()))
                return index;
            index++;
        }
        return 0;
    }

    public void imageOp() {
        Task<Uri> t = FirebaseStorage.getInstance().getReference().child("images/"
                + product.getId()).getDownloadUrl();

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

    public void getSelected() {

    }

    //galeriden foto alma
    public void resimSec(View view) {

        imageView.setOnClickListener(view1 -> launcher.launch("image/*"));


        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, izinReddedildi);
        } else {
            Intent resimAl = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            onActivityResult(izinVerildi, 0, resimAl);
        }
    }

    public void DetailGo(View view) {
        Intent intent = new Intent(this, ExtraSelectPage.class);
        startActivity(intent);
    }

    public void Add(View view) {

        if (getextra == 0)
            product = new Product();
        EditText name = findViewById(R.id.txt_productadd_name);
        EditText price = findViewById(R.id.productaddprice);
        String name_temp = name.getText().toString();
        product.setName(name_temp);
        product.setDisplayRank(99);
        product.setPrice(Integer.parseInt(price.getText().toString()));
//        product.setStatus(spinnerDurum.getSelectedItemPosition());
        product.setCategoryId(categories.get(spinnerCategory.getSelectedItemPosition()).getId());
        if (Data.selectedExtras.size() != 0)
            product.setExtras(Data.selectedExtras);
        String id;
        if (getextra == 0) {
            product.setDescription("***");
            id = FirebaseService.Add(product);
        } else {
            FirebaseService.UpdateData(product);
            id = product.getId();
        }
        StorageReference ref = FirebaseStorage.getInstance().getReference().child("images/" + id);
        UploadTask t = ref.putFile(uri);
        Toast.makeText(this, "İşlem başarılı : " + id, Toast.LENGTH_SHORT).show();
        Data.selectedExtras=new ArrayList<>();
        finish();
    }
}