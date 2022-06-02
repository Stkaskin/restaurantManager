package com.stkaskin.restaurantmanager.Views.Order;

import androidx.appcompat.app.AppCompatActivity;

import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.stkaskin.restaurantmanager.R;

public class OrderCategoryProductsList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_category_products_list);
        LinearLayout layoutBack=findViewById(R.id.linearLayoutCategoryProducts);
        for (int i = 0; i <20; i++) {
            LinearLayout row=new LinearLayout(this);
            row.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,250));
            row.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout p1=new LinearLayout(this);
            p1.setOrientation(LinearLayout.VERTICAL);
            ImageView imageView=new ImageView(this);
            imageView.setImageResource(R.drawable.yan_yemek);
            LinearLayout.LayoutParams p1Params=new LinearLayout.LayoutParams(400, ViewGroup.LayoutParams.MATCH_PARENT);
            p1Params.setMargins(15,7,6,3);
            p1.setLayoutParams(p1Params);
            p1.addView(imageView);

            LinearLayout p2=new LinearLayout(this);
            p2.setOrientation(LinearLayout.VERTICAL);
            p2.setVerticalGravity(View.TEXT_ALIGNMENT_CENTER);
            p2.setHorizontalGravity(View.TEXT_ALIGNMENT_CENTER);
            p2.setLayoutParams(new LinearLayout.LayoutParams(400, ViewGroup.LayoutParams.MATCH_PARENT));
            TextView view=new TextView(this);
            view.setText("BAŞLIK");
            view.setGravity(View.TEXT_ALIGNMENT_CENTER);
            p2.addView(view);
            view=new TextView(this);
            view.setText("BAŞLIK");
            p2.addView(view);
            LinearLayout p3=new LinearLayout(this);
            Button button=new Button(this);
            p3.addView(button);
            p3.setOrientation(LinearLayout.VERTICAL);
            p3.setLayoutParams(new LinearLayout.LayoutParams(200, ViewGroup.LayoutParams.MATCH_PARENT));
            p3.setTag("3");
            p3.setOnClickListener(view1 -> Toast.makeText(this, view1.getTag()+"", Toast.LENGTH_SHORT).show());
            layoutBack.addView(row);
            row.addView(p1);
            row.addView(p2);
            row.addView(p3);
        }


    }
}