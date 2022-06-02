package com.stkaskin.restaurantmanager.Views.Order;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.stkaskin.restaurantmanager.Models.Category;
import com.stkaskin.restaurantmanager.R;

import java.util.ArrayList;

public class OrderCategoryList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_category_list);
        ArrayList<Category> categories=new ArrayList<>();
        Category ct=new Category();
        for (int i = 0; i < 20; i++) {
            ct=new Category();
            ct.setId("ctP"+i);
            ct.setImageid("");;
            ct.setStatus(1);
            ct.setDisplayRank(1);
            ct.setName("Ct"+i);
            categories.add(ct);
        }
        LinearLayout layoutBack=findViewById(R.id.linearLayoutCategories);
        LinearLayout row=new LinearLayout(this);
        for (int i=0;i<categories.size();i++) {
            if (i%2==0) {

                row=new LinearLayout(this);
                row.setOrientation(LinearLayout.HORIZONTAL);
                layoutBack.addView(row);
            }
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(400, 400);
            params.setMargins(40,40,40,0);

            ImageButton view=new ImageButton(this);
            view.setBackgroundResource(R.drawable.ana_yemek);
            view.setLayoutParams(params);
            row.addView(view);


        }
    }
}