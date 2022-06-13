package com.stkaskin.restaurantmanager.Views;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.stkaskin.restaurantmanager.R;
import com.stkaskin.restaurantmanager.Views.Shared.Splash;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent intent = new Intent(this, Splash.class);
        startActivity(intent);


    }
}