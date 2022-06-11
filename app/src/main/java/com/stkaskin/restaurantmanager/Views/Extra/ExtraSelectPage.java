package com.stkaskin.restaurantmanager.Views.Extra;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;

import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.DefaultExtra;
import com.stkaskin.restaurantmanager.Models.Extra;
import com.stkaskin.restaurantmanager.Perdruable.Data;
import com.stkaskin.restaurantmanager.R;

import java.util.ArrayList;

public class ExtraSelectPage extends AppCompatActivity {
    ArrayList<Button> buttons = new ArrayList<>();
    LinearLayout layoutBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra_select_page);
        layoutBack = findViewById(R.id.extraSelectPageLayout);
        Data.selectedExtras = new ArrayList<>();
        getExtras();
    }

    public void getExtras() {
        ArrayList<Extra> extras = FirebaseService.Get(Extra.class);
        ScrollView sc = findViewById(R.id.extraSelectPageLayoutScroll);
        LinearLayout.LayoutParams scLayoutParams = (LinearLayout.LayoutParams) sc.getLayoutParams();
        scLayoutParams.setMargins(30, 10, 30, 10);
        sc.setLayoutParams(scLayoutParams);
        int i = 0;
        LinearLayout layoutRow = null;
        for (Extra item : extras) {


            if (i % 3 == 0) {
                layoutRow = new LinearLayout(this);
                layoutRow.setOrientation(LinearLayout.HORIZONTAL);
                layoutBack.addView(layoutRow);
            }
            i++;
            Button btn = new Button(this);
            btn.setText(item.getName());
            btn.setBackgroundColor(Color.TRANSPARENT);
            btn.setOnClickListener(view -> setButtons(view));
            btn.setTag(item);
            buttons.add(btn);
            layoutRow.addView(btn);


        }
    }

    public void getSelectButtons() {
        ArrayList<DefaultExtra> extras = new ArrayList<>();

        for (Button btn : buttons) {
            int color = ((ColorDrawable) btn.getBackground()).getColor();
            if (color != Color.TRANSPARENT) {
                DefaultExtra defaultExtra = new DefaultExtra();
                Extra extra = (Extra) btn.getTag();
                defaultExtra.setExtraId(extra.getId());
                defaultExtra.setDefaultValue(
                        color == Color.GREEN ? true : false

                );
                extras.add(defaultExtra);
            }


        }
        Data.selectedExtras = extras;
    }

    public void setButtons(View view) {

        Extra m = (Extra) view.getTag();
        int color = ((ColorDrawable) view.getBackground()).getColor();
        if (color == Color.TRANSPARENT) {
            view.setBackgroundColor(Color.GREEN);

        } else if (color == Color.GREEN) {
            view.setBackgroundColor(Color.YELLOW);


        } else {
            view.setBackgroundColor(Color.TRANSPARENT);


        }

    }

    public void Back(View view) {
        finish();
    }

    public void Save(View view) {
        getSelectButtons();
        finish();
    }
}
/*



            buttons.add(button);
 */