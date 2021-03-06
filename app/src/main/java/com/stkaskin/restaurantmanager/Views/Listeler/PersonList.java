package com.stkaskin.restaurantmanager.Views.Listeler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.Person;
import com.stkaskin.restaurantmanager.Perdruable.UpdateData;
import com.stkaskin.restaurantmanager.R;
import com.stkaskin.restaurantmanager.Views.Person.PersonAdd;
import com.stkaskin.restaurantmanager.Widgets.AlerDialogWidget;
import com.stkaskin.restaurantmanager.Widgets.ListWidget;

import java.util.ArrayList;

public class PersonList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_list2);
        ScrollView l = findViewById(R.id.personListLinearScroll);
        ListWidget.marginScrollView(l);
        reflesh();

    }
    public void add(View view) {
    }
    private void reflesh()
    {
        LinearLayout layout=findViewById(R.id.personListLinear);
        layout.removeAllViews();

        ArrayList<Person> people = FirebaseService.Get(Person.class);
        for (Person ct : people)
            ListWidget.listWidget(
                    findViewById(R.id.personListLinear), ct.getId(), ct.getName(), ct,
                    view -> edit(view), view -> delete(view));}
    public void delete(View view) {
        Person ct = (Person) view.getTag();
        AlerDialogWidget.aa(this, (dialogInterface, i) ->
                {
                    FirebaseService.Delete(ct);
                    reflesh();
                    Toast.makeText(this, "Silindi" + ct.getId(), Toast.LENGTH_SHORT).show();

                }
                , (dialogInterface, i) -> {
                    dialogInterface.cancel();
                });
    }

    public void edit(View view) {
        Person ct = (Person) view.getTag();
        Toast.makeText(this, "edit   " + ct.getId(), Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this, PersonAdd.class);
        intent.putExtra("operation",1);
        intent.putExtra("personId",ct.getId());
        startActivityForResult(intent,1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


            reflesh();



    }
    public void back(View view)
    {
        finish();
    }
    public void addNew(View view)
    {
        Intent intent=new Intent(this, PersonAdd.class);
        intent.putExtra("operation",0);
        startActivityForResult(intent,1);
    }
}