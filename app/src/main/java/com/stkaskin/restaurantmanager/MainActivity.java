package com.stkaskin.restaurantmanager;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.Table;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Veritabanı bağlantısı başlatılıyor region Basladi
        ArrayList<Table> tables = FirebaseService.Get(Table.class);

        Object obj = FirebaseService.Get(Table.class);

    }

    public static <T> T documentIdSet(T obj, String data) {

        try {
            obj.getClass().getMethod("setId", String.class).invoke(obj, data);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return obj;


    }

}