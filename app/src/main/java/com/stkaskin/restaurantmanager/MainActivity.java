package com.stkaskin.restaurantmanager;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.stkaskin.restaurantmanager.Models.Table;
import com.stkaskin.restaurantmanager.Views.Table.TableAdd;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Veritabanı bağlantısı başlatılıyor region Basladi
        Table table = new Table();
        table.setId("79JdwyQ9WCWwRI7pY23N");
        // endregion Basladi
        Intent i = new Intent(getApplicationContext(), TableAdd.class);
        startActivity(i);
        //ArrayList<Table> Tables= FirebaseService.ReadData(new Table());
        //     Object obj=  FirebaseService.SearchCustom(new Table(),FirebaseService.QueryCustom(new Table()).whereEqualTo("name","S-30"));
        ///Object obj1=FirebaseService.ReadDataWhereDocumentId(obj,"79JdwyQ9WCWwRI7pY23N");
    }

}