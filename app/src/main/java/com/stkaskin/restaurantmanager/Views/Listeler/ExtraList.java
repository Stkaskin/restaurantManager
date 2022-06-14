package com.stkaskin.restaurantmanager.Views.Listeler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.Category;
import com.stkaskin.restaurantmanager.Models.Extra;
import com.stkaskin.restaurantmanager.Perdruable.UpdateData;
import com.stkaskin.restaurantmanager.R;
import com.stkaskin.restaurantmanager.Views.Category.CategoryAdd;
import com.stkaskin.restaurantmanager.Views.Extra.ExtraAdd;
import com.stkaskin.restaurantmanager.Widgets.AlerDialogWidget;
import com.stkaskin.restaurantmanager.Widgets.ListWidget;

import java.util.ArrayList;

public class ExtraList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra_list);
        ScrollView l = findViewById(R.id.extraListLinearScroll);
        ListWidget.marginScrollView(l);
        reflesh();

    }
    public void add(View view) {
    }
    private void reflesh()
    {
        LinearLayout layout=findViewById(R.id.extraListLinear);
        layout.removeAllViews();

        Extra s=new Extra();

        ArrayList<Extra> extras = FirebaseService.Get(Extra.class,FirebaseService.QueryCreate(Extra.class).whereEqualTo("status",1));
        for (Extra ct : extras)
            ListWidget.listWidget(
                    findViewById(R.id.extraListLinear), ct.getId(), ct.getName(), ct,
                    view -> edit(view), view -> delete(view));
    }
    public void delete(View view) {
        Extra ct = (Extra) view.getTag();

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
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


            reflesh();



    }

    public void edit(View view) {
        Extra  ct = (Extra) view.getTag();
        Toast.makeText(this, "edit   " + ct.getId(), Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this, ExtraAdd.class);
        intent.putExtra("operation",1);
        intent.putExtra("extraId",ct.getId());
        startActivityForResult(intent,1);
    }
    public void back(View view)
    {
        finish();
    }
    public void addNew(View view)
    {
        Intent intent=new Intent(this, ExtraAdd.class);
        intent.putExtra("operation",0);
        startActivityForResult(intent,1);

    }

}