package com.stkaskin.restaurantmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList liste=Dataeleman.getArrayListElemanlar();
        TextView v=findViewById(R.id.textView);
        v.setText("");
        for (String item:Dataeleman.getArrayListElemanlar()) {
            v.append(item);
        }

    }
}