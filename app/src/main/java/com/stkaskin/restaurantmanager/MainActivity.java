package com.stkaskin.restaurantmanager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.Extra;
import com.stkaskin.restaurantmanager.Models.Table;
import com.stkaskin.restaurantmanager.Views.Category.CategoryAdd;
import com.stkaskin.restaurantmanager.Views.Extra.ExtraAdd;
import com.stkaskin.restaurantmanager.Views.Order.OrderCategoryProductExtras;
import com.stkaskin.restaurantmanager.Views.Order.OrderCategoryProductsList;
import com.stkaskin.restaurantmanager.Views.Order.OrderProductsList;
import com.stkaskin.restaurantmanager.Views.Person.PersonAdd;
import com.stkaskin.restaurantmanager.Views.Product.Product_Add;
import com.stkaskin.restaurantmanager.Views.Table.TableAdd;
import com.stkaskin.restaurantmanager.Views.Table.TableList;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import soup.neumorphism.NeumorphCardView;
import soup.neumorphism.NeumorphImageButton;
import soup.neumorphism.ShapeType;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent m=new Intent(this, OrderProductsList.class);
        m.putExtra("idTable","6glWDzVu0uoxAYDIje9G");
        startActivity(m);
LinearLayout layout= findViewById(R.id.mainP);
        NeumorphImageButton button = new NeumorphImageButton(this);
        button = new NeumorphImageButton(this);
        //  button.setText(tables.get(i).getName());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, Gravity.CENTER
        );

button.setImageResource(R.drawable.ana_yemek);
        button.setShapeType(ShapeType.FLAT);
        params.setMargins(5, 5, 5, 5);
        params.width = 350;
        params.height = 350;
        button.setLayoutParams(params);
layout.addView(button);
        //Veritabanı bağlantısı başlatılıyor region Basladi
        //ArrayList<Table> tables = FirebaseService.Get(Table.class);

   //     Object obj = FirebaseService.Get(Table.class);

    }
    public void porcuS(View view) throws InterruptedException {


    }
  /*  @Override
     onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN ->
            setShapeType(ShapeType.PRESSED)
            MotionEvent.ACTION_UP ->
            setShapeType(ShapeType.FLAT)
        }
        return super.onTouchEvent(event)
    }*/



}