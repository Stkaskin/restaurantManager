package com.stkaskin.restaurantmanager.Views.Listeler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.Product;
import com.stkaskin.restaurantmanager.Perdruable.UpdateData;
import com.stkaskin.restaurantmanager.R;
import com.stkaskin.restaurantmanager.Views.Product.Product_Add;
import com.stkaskin.restaurantmanager.Widgets.AlerDialogWidget;
import com.stkaskin.restaurantmanager.Widgets.ListWidget;

import java.util.ArrayList;

public class ProductList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        ScrollView l = findViewById(R.id.productListLinearScroll);
        ListWidget.marginScrollView(l);
        reflesh();

    }
    private void reflesh()
    {
        LinearLayout layout=findViewById(R.id.productListLinear);
        layout.removeAllViews();
        ArrayList<Product> products = FirebaseService.Get(Product.class,FirebaseService.QueryCreate(Product.class).whereEqualTo("status",1));
        for (Product ct : products)
            ListWidget.listWidget(
                    findViewById(R.id.productListLinear), ct.getId(), ct.getName(), ct,
                    view -> edit(view), view -> delete(view));
    }
    public void add(View view) {
    }

    public void delete(View view) {
        Product ct = (Product) view.getTag();
        AlerDialogWidget.no_=AlerDialogWidget.default_no;
        AlerDialogWidget.yes_=AlerDialogWidget.default_yes;
        AlerDialogWidget.description=AlerDialogWidget.default_description;
        AlerDialogWidget.title=AlerDialogWidget.default_title;
        AlerDialogWidget.aa(this, (dialogInterface, i) ->
                {
                    ct.setStatus(-1);
                    FirebaseService.UpdateData(ct);
                    reflesh();
                    Toast.makeText(this, "Silindi" + ct.getId(), Toast.LENGTH_SHORT).show();

                }
                , (dialogInterface, i) -> {
                    dialogInterface.cancel();
                });
    }

    public void edit(View view) {
        Product ct = (Product) view.getTag();
        Toast.makeText(this, "edit   " + ct.getId(), Toast.LENGTH_SHORT).show();

        Intent intent=new Intent(this, Product_Add.class);
        intent.putExtra("operation",1);
        intent.putExtra("productId",ct.getId());
        startActivityForResult(intent,1);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


            reflesh();



    }

    public void back(View view) {
        finish();
    }

    public void addNew(View view) {
        Intent intent=new Intent(this, Product_Add.class);
        intent.putExtra("operation",0);
        startActivityForResult(intent,1);
    }
}