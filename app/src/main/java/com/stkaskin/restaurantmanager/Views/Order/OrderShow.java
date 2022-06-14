package com.stkaskin.restaurantmanager.Views.Order;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableRow;

import androidx.appcompat.app.AppCompatActivity;

import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.BigOrder;
import com.stkaskin.restaurantmanager.Models.Extra;
import com.stkaskin.restaurantmanager.Models.ExtraProduct;
import com.stkaskin.restaurantmanager.Models.Product;
import com.stkaskin.restaurantmanager.Models.detailOrder;
import com.stkaskin.restaurantmanager.R;

import java.util.ArrayList;

import soup.neumorphism.NeumorphTextView;

public class OrderShow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_show);
        String id = getIntent().getStringExtra("orderShowId");



            load(id);

    }

    public void Back(View view) {
        finish();
    }

    private void load(String id) {
        LinearLayout layout = findViewById(R.id.OrderShow1);
        NeumorphTextView tutar = new NeumorphTextView(this);
        layout.addView(tutar);
        BigOrder order = FirebaseService.Get(BigOrder.class, id);
        if (order!=null )
            tutar.setText("Toplam Tutar : "+ order.getTotal()+"");
        ArrayList<detailOrder> orders = order.getOrders();
        for (detailOrder item : orders) {
            LinearLayout row = new LinearLayout(this);
            Product product = FirebaseService.Get(Product.class, item.getProductId());
            NeumorphTextView name = new NeumorphTextView(this);

            name.setText("ÜRÜN ADI : " + product.getName());
            name.setGravity(View.TEXT_ALIGNMENT_CENTER);
            NeumorphTextView fiyat = new NeumorphTextView(this);
            fiyat.setText("FİYAT : " + product.getPrice() + "");
            NeumorphTextView icerik = new NeumorphTextView(this);
            String icerik_ = "İÇERİK : ";
            ArrayList<ExtraProduct> extras = item.getExtras();
            for (ExtraProduct extraProduct : extras) {
                if (extraProduct.isSelect()) {
                    Extra extra = FirebaseService.Get(Extra.class, extraProduct.getExtraid());
                    if (extra != null)
                        icerik_ += extra.getName() + " , ";
                }
            }
            icerik.setText(icerik_);
            row.addView(name);
            row.addView(fiyat);
            row.addView(icerik);
            row.setOrientation(LinearLayout.VERTICAL);
            layout.addView(row);
            TableRow rowBorder = new TableRow(this);
            rowBorder.setBackgroundColor(Color.BLACK);
            rowBorder.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 2));

            layout.addView(rowBorder);
        }


    }

}