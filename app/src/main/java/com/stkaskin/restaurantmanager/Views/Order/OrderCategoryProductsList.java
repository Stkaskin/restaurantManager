package com.stkaskin.restaurantmanager.Views.Order;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.squareup.picasso.Picasso;
import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.Product;
import com.stkaskin.restaurantmanager.Perdruable.Data;

import com.stkaskin.restaurantmanager.Perdruable.Page;
import com.stkaskin.restaurantmanager.R;
import com.stkaskin.restaurantmanager.SharedOperation;
import com.stkaskin.restaurantmanager.Widgets.OrderWidget;

import java.util.ArrayList;
import java.util.Random;

import soup.neumorphism.NeumorphImageView;
import soup.neumorphism.NeumorphTextView;

public class OrderCategoryProductsList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_category_products_list);
        Page.addActivity(this);
        LinearLayout layoutBack = findViewById(R.id.linearLayoutCategoryProducts);
        ScrollView sc = findViewById(R.id.linearLayoutCategoryProducts_scroll);
       // OrderWidget.setOrderLayout(this,findViewById(R.id.OrderHeader_Product),findViewById(R.id.OrderFooter_Product));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)sc.getLayoutParams();
        layoutParams.setMargins(30, 20, 30, 0);
        sc.setLayoutParams(layoutParams);
        ArrayList<Product> products = new ArrayList<>();

        products= FirebaseService.Get(
                Product.class,FirebaseService.QueryCreate(Product.class).whereEqualTo("categoryId",getIntent().getStringExtra("CategoryId"))
        );

        for (int i = 0; i <products.size(); i++) {
            Product pr =products.get(i);

            LinearLayout rowT = new LinearLayout(this);
            rowT.setTag(pr);

            rowT.setOnClickListener(this::OnClick);
            rowT.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200));
            LinearLayout row = new LinearLayout(this);
            row.setLayoutParams(new LinearLayout.LayoutParams(800, ViewGroup.LayoutParams.MATCH_PARENT));
            row.setOrientation(LinearLayout.VERTICAL);
            TextView tx = new NeumorphTextView(this);
            tx.setText(pr.getName());
            row.addView(tx);
            tx = new NeumorphTextView(this);
            tx.setText("description : "+pr.getDescription());
            row.addView(tx);
            tx = new NeumorphTextView(this);
            tx.setText(pr.getPrice()+ " TL");
            row.addView(tx);

            rowT.addView(row);


            row = new LinearLayout(this);
            row.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

            NeumorphImageView view = new NeumorphImageView(this);
            view.setImageResource(R.drawable.ana_yemek);
            view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200));
            Task<Uri> t = FirebaseStorage.getInstance().getReference().child("images/"
                    + pr.getId()).getDownloadUrl();
            t.addOnSuccessListener(runnable ->
            {    Picasso.get().load(t.getResult()).into(view);
            });
            row.addView(view);


            rowT.addView(row);
            TableRow rowBorder = new TableRow(this);
            rowBorder.setBackgroundColor(Color.BLACK);
            rowBorder.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 2));
            layoutBack.addView(rowT);
            layoutBack.addView(rowBorder);


        }

    }

    /*
       TableRow row=new TableRow(this);
            row.setLayoutParams(new LinearLayout.LayoutParams(20,100));
            row.setBackgroundColor(Color.RED);
            verticalLayout.addView(row);
    * */
    public void OnClick(View view) {
        Product product = (Product) view.getTag();
        Toast.makeText(this, product.getName() + "", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,OrderCategoryProductExtras.class);
        intent.putExtra("ProductId",product.getId());
        startActivity(intent);
    }
    public void tableOperation(View view
    ){
        SharedOperation.tableOperation(Data.table.getId());
    }
    public void Back(View view){finish();}
    public void BackAll(View view){Page.CloseActivities();}


}