package com.stkaskin.restaurantmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.stkaskin.restaurantmanager.Interface.IIntent;
import com.stkaskin.restaurantmanager.Perdruable.Page;
import com.stkaskin.restaurantmanager.Views.Table.TableList;

import soup.neumorphism.NeumorphImageButton;
import soup.neumorphism.ShapeType;

public class MainActivity extends AppCompatActivity implements IIntent {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     //   FakeOperation.addBigOrder();
      //  FakeOperation.addProduct();
     //   FakeOperation.addProduct();

        Intent m = Page.IntentGet(new Intent(this, TableList.class));
        ///* for OrderproductList */m.putExtra("idTable", "6glWDzVu0uoxAYDIje9G");
        startActivity(m);
        LinearLayout layout = findViewById(R.id.mainP);
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

    @Override
    public void Update() {

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