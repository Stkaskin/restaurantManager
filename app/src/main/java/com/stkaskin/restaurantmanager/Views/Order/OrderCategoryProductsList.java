package com.stkaskin.restaurantmanager.Views.Order;

import android.content.Intent;
import android.graphics.Color;
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

import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.Product;
import com.stkaskin.restaurantmanager.R;
import com.stkaskin.restaurantmanager.Widgets.OrderWidget;

import java.util.ArrayList;
import java.util.Random;

public class OrderCategoryProductsList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_category_products_list);
        LinearLayout layoutBack = findViewById(R.id.linearLayoutCategoryProducts);
        ScrollView sc = findViewById(R.id.linearLayoutCategoryProducts_scroll);
        OrderWidget.setOrderLayout(this,findViewById(R.id.OrderHeader_Product),findViewById(R.id.OrderFooter_Product));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

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
            TextView tx = new TextView(this);
            tx.setText(pr.getName());
            row.addView(tx);
            tx = new TextView(this);
            tx.setText(pr.getDescription());
            row.addView(tx);
            tx = new TextView(this);
            tx.setText(new Random().nextInt(500) + " TL");
            row.addView(tx);

            rowT.addView(row);


            row = new LinearLayout(this);
            row.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

            ImageView view = new ImageView(this);
            view.setImageResource(R.drawable.ana_yemek);
            view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200));

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


}