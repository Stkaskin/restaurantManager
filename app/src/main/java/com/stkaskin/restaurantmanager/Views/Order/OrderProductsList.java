package com.stkaskin.restaurantmanager.Views.Order;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.Query;
import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.Order;
import com.stkaskin.restaurantmanager.Models.OrderDetail;
import com.stkaskin.restaurantmanager.Models.Product;
import com.stkaskin.restaurantmanager.Models.Table;
import com.stkaskin.restaurantmanager.R;

import java.util.ArrayList;

public class OrderProductsList extends AppCompatActivity {
    LinearLayout layoutBack;
    ArrayList<Product> products = new ArrayList<>();
    Table table = new Table();
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_products_list);
        layoutBack = findViewById(R.id.linearLayoutProducts);

       /* Product product = new Product();
        product.setId("1");
        product.setName("sadas");
        products.add(product);
        product = new Product();
        product.setId("2");
        product.setName("sadas");
        products.add(product);
        product = new Product();
        product.setId("3");
        product.setName("sadas");
        products.add(product);
        product = new Product();
        product.setId("4");
        product.setName("sadas");
        products.add(product);*/

        String id = getIntent().getStringExtra("idTable");

        table = FirebaseService.Get(Table.class, id);
        ArrayList<Order> orders = new ArrayList<Order>();
        if (table.getStatus() == 1) {

            String tableId = table.getId().trim();
            ArrayList<OrderDetail> details = new ArrayList<>();
            Order order_ = OrderGet(tableId);
            if (order_ != null) {
                details = FirebaseService.Get(OrderDetail.class,
                        FirebaseService.QueryCreate(OrderDetail.class).whereEqualTo("orderid", order_.getId())
                );
            }
            products = new ArrayList<>();
            if (details != null)
                for (OrderDetail detail : details) {
                    Product product_ = FirebaseService.Get(Product.class, detail.getProductid().trim());
                    if (product_ != null)
                        products.add(product_);
                }
            if (products.size() > 0)
                GetTableDynamic(layoutBack, products);
            //  products=FirebaseService.Get(Product.class);
            // GetTableDynamic(layoutBack, products);
        } else if (table.getStatus() == 2) {

        } else
            Toast.makeText(this, "Sipariş ALınmadı", Toast.LENGTH_SHORT).show();

        TextView tx = findViewById(R.id.textview_order_products_1);
        tx.setText("Masa Id    :" + table.getId() + "");
        tx = findViewById(R.id.textview_order_products_2);
        tx.setText("Masa Adı   :" + table.getName() + "");
        tx = findViewById(R.id.textview_order_products_3);
        tx.setText("Masa Durum :" + table.getStatus() + "");
        // Rezerve("1");
    }

    private Order OrderGet(String tableId) {
        Order order_ = new Order();
        for (Order item : OrdersGet(tableId)) {
            if (item.getTableId().trim().equals(tableId.trim())) {
                return item;

            }
        }
        return null;
    }

    private ArrayList<Order> OrdersGet(String id) {
        ArrayList<Order> orders = new ArrayList<>();
        Class class_ = com.stkaskin.restaurantmanager.Models.Order.class;
        Query q = FirebaseService.QueryCreate(class_);
        q = q.whereEqualTo("status", 1);
        orders = FirebaseService.Get(class_, q);
        if (orders == null)
            return new ArrayList<Order>();
        return orders;
    }

    private void Rezerve(String id) {


    }

    /*
    Full ekran komutu
    View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);

    */
    private LinearLayout GetTableDynamic(LinearLayout layoutBack, ArrayList<Product> items) {
        TextView textView = new TextView(this);
        LinearLayout row = new LinearLayout(this);
        for (int i = 0; i < items.size(); i++) {

            row = new LinearLayout(this);
            row.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams paramsRow = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 250);
            paramsRow.setMargins(10, 10, 10, 0);
            row.setLayoutParams(paramsRow);
            layoutBack.addView(row);
            textView = new TextView(this);
            textView.setText(items.get(i).getName());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    130
            );

            params.setMargins(5, 30, 5, 0);
            textView.setId(i);

            textView.setTag(items.get(i));
            textView.setLayoutParams(params);
            // textView.setOnClickListener(this::click);
            row.addView(textView);
            row.addView(getProductButtonsAndEditText(i));


        }
        return layoutBack;
    }

    public LinearLayout getProductButtonsAndEditText(int index) {
        LinearLayout.LayoutParams paramsRow = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);


        LinearLayout.LayoutParams layoutButtonsParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        LinearLayout layoutButtons = new LinearLayout(this);
        layoutButtons.setOrientation(LinearLayout.HORIZONTAL);

        layoutButtons.setGravity(Gravity.RIGHT);
        paramsRow.setMargins(0, 30, 20, 5);
        layoutButtons.setLayoutParams(paramsRow);

        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(70, 70);
        params1.topMargin = 50;
        params1.setMargins(30, 30, 30, 30);

        Button button = new Button(this);
        button.setOnClickListener(this::ClickPlus);
        button.setBackgroundResource(R.drawable.plusbutton);

        button.setWidth(100);
        button.setTag(products.get(index));
        button.setLayoutParams(params1);
        layoutButtons.addView(button);

        LinearLayout.LayoutParams tparams1 = new LinearLayout.LayoutParams(70, 120);
        EditText text = new EditText(this);
        tparams1.width = 125;
        text.setLayoutParams(tparams1);
        text.setTag(products.get(index));
        text.setInputType(InputType.TYPE_CLASS_NUMBER);
        layoutButtons.addView(text);

        button = new Button(this);
        button.setTag(products.get(index));
        button.setOnClickListener(this::ClickMinus);
        button.setBackgroundResource(R.drawable.minusbutton);
        button.setLayoutParams(params1);
        params1.gravity = Gravity.END;

        button.setGravity(Gravity.END);
        layoutButtonsParams.topMargin = 20;
        layoutButtonsParams.gravity = Gravity.CENTER;
        layoutButtons.setLayoutParams(layoutButtonsParams);

        layoutButtons.addView(button);
        return layoutButtons;
    }

    public void ClickPlus(@NonNull View v) {
        Product product = (Product) v.getTag();
        Toast.makeText(this, product.getId() + " Eklendi", Toast.LENGTH_SHORT).show();

    }

    public void ClickMinus(@NonNull View v) {
        Product product = (Product) v.getTag();
        Toast.makeText(this, product.getId(), Toast.LENGTH_SHORT).show();
    }

    public void addNew(View view) {
        Intent intent = new Intent(this, OrderCategoryList.class);
        intent.putExtra("TableId",table.getId());
        startActivity(intent);
    }

}