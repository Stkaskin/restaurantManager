package com.stkaskin.restaurantmanager.Views.Listeler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.Category;
import com.stkaskin.restaurantmanager.R;
import com.stkaskin.restaurantmanager.Views.Category.CategoryAdd;
import com.stkaskin.restaurantmanager.Widgets.ListWidget;

import java.util.ArrayList;

public class CategoryList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);
        ScrollView l = findViewById(R.id.categoryListLinearScroll);
        ListWidget.marginScrollView(l);
        reflesh();

    }
    public void reflesh()
    {
    LinearLayout layout=    findViewById(R.id.categoryListLinear);
    layout.removeAllViews();
        ArrayList<Category> categories = FirebaseService.Get(Category.class);
        for (Category ct : categories)
            ListWidget.listWidget(
                    layout, ct.getId(), ct.getName(), ct,
                    view -> edit(view), view -> delete(view));
    }


    public void delete(View view) {

        Category ct = (Category) view.getTag();
        FirebaseService.Delete(ct);

        Toast.makeText(this,"Silindi"+ ct.getId(), Toast.LENGTH_SHORT).show();
    }

    public void edit(View view) {
        Category ct = (Category) view.getTag();
        Intent intent=new Intent(this, CategoryAdd.class);
        intent.putExtra("operation",1);
        intent.putExtra("categoryId",ct.getId());
        startActivity(intent);


        Toast.makeText(this, "edit   " + ct.getId(), Toast.LENGTH_SHORT).show();
    }
    public void back(View view)
    {
        finish();
    }
    public void addNew(View view)
    {
        Intent intent=new Intent(this, CategoryAdd.class);
        intent.putExtra("operation",0);
        startActivity(intent);
        reflesh();

    }
}