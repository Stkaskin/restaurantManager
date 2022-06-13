package com.stkaskin.restaurantmanager.Views.Order;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.Query;
import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.BigOrder;
import com.stkaskin.restaurantmanager.Models.Model.OrderProductListModel;
import com.stkaskin.restaurantmanager.Models.Order;
import com.stkaskin.restaurantmanager.Models.Product;
import com.stkaskin.restaurantmanager.Models.Table;
import com.stkaskin.restaurantmanager.Models.detailOrder;
import com.stkaskin.restaurantmanager.Perdruable.Data;
import com.stkaskin.restaurantmanager.Perdruable.Page;
import com.stkaskin.restaurantmanager.Perdruable.UpdateData;
import com.stkaskin.restaurantmanager.R;
import com.stkaskin.restaurantmanager.SharedOperation;
import com.stkaskin.restaurantmanager.Widgets.AlerDialogWidget;

import java.util.ArrayList;

import soup.neumorphism.NeumorphFloatingActionButton;
import soup.neumorphism.NeumorphTextView;

public class OrderProductsList extends AppCompatActivity {
    LinearLayout layoutBack;
    ArrayList<Product> products = new ArrayList<>();
    Table table = new Table();
    OrderProductListModel model = new OrderProductListModel();
    BigOrder order;

    int lastStatu = 0;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_products_list);


        layoutBack = findViewById(R.id.linearLayoutProducts);
        Page.addActivity(this);

        String id = getIntent().getStringExtra("idTable");

        table = FirebaseService.Get(Table.class, id);
        Data.table = table;
        model.setTable(table);
        ArrayList<Order> orders = new ArrayList<Order>();
        lastStatu = table.getStatus();
        UpdateData.tableProductUpdate = false;
        headerTextOp();
        OrderOp();
        // Rezerve("1");
        findViewById(R.id.textview_order_products_3).setOnClickListener(
                view -> OrderOp()
        );
        xt = this;

    }


    Context xt;
    int isz = 0;


    public void headerTextOp() {
        table = FirebaseService.Get(Table.class, table.getId());

        TextView tx = findViewById(R.id.textview_order_products_1);
        ArrayList<BigOrder> order = FirebaseService.Get(BigOrder.class,
                FirebaseService.QueryCreate(BigOrder.class).whereEqualTo("tableId", table.getId()).whereEqualTo("status", 1));
        if (order != null && order.size() > 0)
            tx.setText("Tutar:" + order.get(0).getTotal());
        else
            tx.setText("Tutar:" + 0);
        model.setP1(tx);

        tx = findViewById(R.id.textview_order_products_2);
        tx.setText("Masa Adı   :" + table.getName());
        model.setP2(tx);
        tx = findViewById(R.id.textview_order_products_3);
        tx.setText("Masa Durum :" + table.getStatus());
        model.setP3(tx);
    }

    private void OrderOp() {
        if (table.getStatus() == 1) {

            products = new ArrayList<>();
            Query q = FirebaseService.QueryCreate(BigOrder.class);

            ArrayList<Integer> degerler = new ArrayList<>();
            degerler.add(0);
            degerler.add(1);
            degerler.add(2);
            q = q.whereEqualTo("tableId", table.getId().trim());
            ArrayList<BigOrder> orders = FirebaseService.Get(BigOrder.class, q);
            for (int i = 0; i < orders.size(); i++) {
                if (orders.get(i).getStatus() == 3) {
                    orders.remove(i);
                    i--;
                }
            }
            if (orders != null && orders.size() > 0 && orders.get(0).getStatus() != 3) {
                order = orders.get(0);
                for (detailOrder detail : order.getOrders()) {
                    Product product_ = FirebaseService.Get(Product.class, detail.getProductId().trim());
                    if (product_ != null)
                        products.add(product_);
                }
                if (products.size() > 0)
                    GetTableDynamic(layoutBack, products);
            }

        } else if (table.getStatus() == 2) {

        } else
            Toast.makeText(this, "Sipariş ALınmadı", Toast.LENGTH_SHORT).show();
        headerTextOp();


    }

    private Order OrdersGet(String tableId) {
        ArrayList<Order> orders = new ArrayList<>();
        Class class_ = com.stkaskin.restaurantmanager.Models.Order.class;
        Query q = FirebaseService.QueryCreate(class_);
        //bitmiş siparişler  haric masanın siparişlerini getir hepsini getir
        q = q.whereEqualTo("tableId", tableId);
        orders = FirebaseService.Get(class_, q);
        if (orders != null && orders.size() > 0)
            return orders.get(0);
        return null;
    }


    private LinearLayout GetTableDynamic(LinearLayout layoutBack, ArrayList<Product> items) {
        TextView textView;
        LinearLayout row;
        layoutBack.removeAllViews();
        for (int i = 0; i < items.size(); i++) {

            row = new LinearLayout(this);
            row.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams paramsRow = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 250);
            paramsRow.setMargins(10, 10, 10, 0);
            row.setLayoutParams(paramsRow);
            layoutBack.addView(row);
            TableRow rowBorder = new TableRow(this);
            rowBorder.setBackgroundColor(Color.BLACK);
            rowBorder.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 2));

            layoutBack.addView(rowBorder);
            textView = new NeumorphTextView(this, null, R.style.Widget_Neumorph_TextView);
            textView.setText((i + 1) + ". " + items.get(i).getName());
            textView.setTypeface(null, Typeface.NORMAL);
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

        NeumorphFloatingActionButton button = new NeumorphFloatingActionButton(this);
        button.setOnClickListener(this::ClickPlus);
        button.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        button.setImageResource(R.drawable.plusbutton);
        //button.setBackgroundResource(R.style.Widget_Neumorph.ImageButton);


        button.setTag(products.get(index));
        button.setLayoutParams(params1);
        // layoutButtons.addView(button);

        LinearLayout.LayoutParams tparams1 = new LinearLayout.LayoutParams(70, 120);
        EditText text = new EditText(this);
        tparams1.width = 125;
        text.setLayoutParams(tparams1);
        text.setTag(products.get(index));
        text.setInputType(InputType.TYPE_CLASS_NUMBER);
        text.setTag(products.get(index));

        text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        text.setText(order.getOrders().get(index).getCount() + "");
        //  layoutButtons.addView(text);

        button = new NeumorphFloatingActionButton(this);
        button.setTag(products.get(index));
        button.setOnClickListener(this::ClickMinus);
        button.setImageResource(R.drawable.minusbutton);
        button.setLayoutParams(params1);
        params1.gravity = Gravity.END;

        //  button.setForegroundGravity(Gravity.END);
        layoutButtonsParams.topMargin = 20;
        layoutButtonsParams.gravity = Gravity.CENTER;
        layoutButtons.setLayoutParams(layoutButtonsParams);

        layoutButtons.addView(button);
        return layoutButtons;
    }

    public void ClickPlus(@NonNull View v) {
        Product product = (Product) v.getTag();
        //  Toast.makeText(this, product.getId() + " Eklendi", Toast.LENGTH_SHORT).show();

    }

    public void ClickMinus(@NonNull View v) {
        Product product = (Product) v.getTag();
        Toast.makeText(this, product.getId(), Toast.LENGTH_SHORT).show();
        AlerDialogWidget.aa(layoutBack.getContext(), (dialogInterface, i) ->
        {
            BigOrder bigOrders = FirebaseService.Get(BigOrder.class,order.getId());
            for (int x=0;x<bigOrders.getOrders().size();x++) {
                if (bigOrders.getOrders().get(x).getProductId().equals(product.getId())) {
                    bigOrders.getOrders().remove(x);

                    FirebaseService.UpdateData(bigOrders);
                    headerTextOp();
                    OrderOp();
                    break;
                }
            }
        }, (dialogInterface, i) -> {
        });
    }

    int LAUNCH_SECOND_ACTIVITY = 1;

    public void addNew(View view) {
        Intent intent = new Intent(this, OrderCategoryList.class);
        intent.putExtra("TableId", table.getId());

        startActivityForResult(intent, LAUNCH_SECOND_ACTIVITY);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (UpdateData.tableProductUpdate) {
            UpdateData.tableProductUpdate = false;
            UpdateData.tableUpdate = true;
            headerTextOp();
            OrderOp();
        }


    } //onActivityResult

    public void tableOperation(View view
    ) {
        SharedOperation.tableOperation(Data.table.getId());
    }

    public void Back(View view) {
        finish();
    }

    public void BackAll(View view) {
        Page.CloseActivities();
    }

}


