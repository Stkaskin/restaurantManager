package com.stkaskin.restaurantmanager.Views.Order;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.stkaskin.restaurantmanager.R;

public class OrderCategoryProductsList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_category_products_list);
        LinearLayout layoutBack = findViewById(R.id.linearLayoutCategoryProducts);
        for (int i = 0; i < 20; i++) {
            LinearLayout row = new LinearLayout(this);
            row.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 250));
            row.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout layout = new LinearLayout(this);
            TextView view = new TextView(this);
            view.setText("başlık\naçıklama\nFiyat");
            layout.addView(view);
            LinearLayout p1 = new LinearLayout(this);
            p1.setOrientation(LinearLayout.VERTICAL);
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(R.drawable.yan_yemek);
            p1.setLayoutParams(new LinearLayout.LayoutParams(200, ViewGroup.LayoutParams.MATCH_PARENT));
            p1.addView(imageView);

            row.addView(layout);
            row.addView(p1);
            layoutBack.addView(row);

        }


    }
}