package com.stkaskin.restaurantmanager.Views.Order;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.Category;
import com.stkaskin.restaurantmanager.R;
import com.stkaskin.restaurantmanager.Widgets.OrderWidget;

import java.util.ArrayList;

import soup.neumorphism.NeumorphImageButton;

public class OrderCategoryList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_category_list);
        OrderWidget.setOrderLayout(this, findViewById(R.id.OrderHeader_Category), findViewById(R.id.OrderFooter_Category));

        ArrayList<Category> categories = new ArrayList<>();
        categories = FirebaseService.Get(Category.class);
        LinearLayout layoutBack = findViewById(R.id.linearLayoutCategories);
        LinearLayout row = new LinearLayout(this);
        for (int i = 0; i < categories.size(); i++) {
            if (i % 1 == 0) {

                row = new LinearLayout(this);
                row.setOrientation(LinearLayout.HORIZONTAL);
                layoutBack.addView(row);
            }
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 400 );
            params.setMargins(40, 40, 40, 0);

            NeumorphImageButton view = new NeumorphImageButton(this,null,R.style.Widget_Neumorph_ImageButton);
            view.setImageResource(R.drawable.ana_yemek);
            view.setLayoutParams(params);
            view.setScaleType(ImageView.ScaleType.FIT_XY);
            view.setTag(categories.get(i));
            view.setOnClickListener(view1 ->
            {
                Category c = (Category) view1.getTag();
                Intent intent = new Intent(this, OrderCategoryProductsList.class);
                intent.putExtra("CategoryId", c.getId());
                startActivity(intent);
            });
            row.addView(view);


        }
    }
}