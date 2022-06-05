package com.stkaskin.restaurantmanager.Views.Order;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.color.ColorRoles;
import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.Extra;
import com.stkaskin.restaurantmanager.Models.ExtraDetail;
import com.stkaskin.restaurantmanager.Models.Model.ExtraAndDetailModel;
import com.stkaskin.restaurantmanager.Models.Model.ExtraModel;
import com.stkaskin.restaurantmanager.Models.Product;
import com.stkaskin.restaurantmanager.Models.SpecialExtraList;
import com.stkaskin.restaurantmanager.R;

import java.util.ArrayList;

public class OrderCategoryProductExtras extends AppCompatActivity {

    Product product = new Product();
    ArrayList<ExtraModel> models = new ArrayList<>();

    public void add() {
        product = FirebaseService.Get(Product.class, "8tETf4wQw6sOdtLkVO8v");
        SpecialExtraList specialExtraList = FirebaseService.Get(SpecialExtraList.class,
                product.getExtraSpeacialListId());
        ArrayList<ExtraDetail> extraDetails = FirebaseService.Get(ExtraDetail.class,
                FirebaseService.QueryCreate(ExtraDetail.class).whereEqualTo("specialExtraListId", specialExtraList.getId())
        );

        ArrayList<ExtraAndDetailModel> extraAndDetailModels = new ArrayList<>();
        for (ExtraDetail item : extraDetails) {

            ExtraAndDetailModel ed = new ExtraAndDetailModel();
            ed.setDetail(item);
            ed.setExtra(FirebaseService.Get(Extra.class, item.getExtraId()));
            extraAndDetailModels.add(ed);
        }
        for (int k = 0; k < extraAndDetailModels.size(); ) {


            int mn = extraAndDetailModels.get(0).getExtra().getType();
            for (ExtraAndDetailModel m : extraAndDetailModels) {
                if (mn > m.getExtra().getType())
                    mn = m.getExtra().getType();
            }
            ExtraModel ms = new ExtraModel();

            for (int xs = 0; xs < extraAndDetailModels.size(); xs++) {
                if (extraAndDetailModels.get(xs).getExtra().getType() == mn) {
                    ms.getModels().add(extraAndDetailModels.get(xs));
                    extraAndDetailModels.remove(extraAndDetailModels.get(xs));
                    xs--;
                }
            }
            ms.setHeader(mn + "");
            models.add(ms);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_category_product_extras);
        LinearLayout layoutBack = findViewById(R.id.linearLayoutCategoryProductExtras);
        add();
        for (ExtraModel item : models) {


            LinearLayout layoutRow = new LinearLayout(this);
            layoutRow.setOrientation(LinearLayout.VERTICAL);
            ScrollView sc = findViewById(R.id.linearLayoutCategoryProductExtra_scroll);
            LinearLayout.LayoutParams scLayoutParams = (LinearLayout.LayoutParams) sc.getLayoutParams();
            scLayoutParams.setMargins(30, 10, 30, 10);
            sc.setLayoutParams(scLayoutParams);
            HorizontalScrollView viewScroll = new HorizontalScrollView(this);

            viewScroll.addView(layoutRow);
            LinearLayout rowHeader = new LinearLayout(this);

            layoutRow.addView(rowHeader);
            LinearLayout row1 = new LinearLayout(this);
            LinearLayout row2 = new LinearLayout(this);
            for (int i = 0; i < item.getModels().size(); i++) {
                Button button=new Button(this);
                //statü kontrolüne göre renk verilecek
                button.setBackgroundColor(Color.TRANSPARENT);
                button.setText(item.getModels().get(i).getExtra().getName());
                button.setTag(item.getModels().get(i));
                button.setOnClickListener(view ->
                {
                    if (((ColorDrawable)view.getBackground()).getColor()==Color.TRANSPARENT)
                        view.setBackgroundColor(Color.GREEN);
                    else
                        view.setBackgroundColor(Color.TRANSPARENT);
                });
                if (i % 2 == 0)
                    row1.addView(button);
                else
                    row2.addView(button);
            }

            layoutRow.addView(row1);
            layoutRow.addView(row2);
            TableRow rowBorder = new TableRow(this);
            rowBorder.setBackgroundColor(Color.BLACK);
            rowBorder.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 2));
            TextView view = new TextView(this);
            view.setText(item.getHeader()+"");
            LinearLayout layoutFullRow = new LinearLayout(this);
            layoutFullRow.setOrientation(LinearLayout.VERTICAL);
            layoutFullRow.addView(view);
            layoutFullRow.addView(viewScroll);


            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) rowBorder.getLayoutParams();
            params.setMargins(10, 20, 20, 20);
            rowBorder.setLayoutParams(params);
            layoutBack.addView(layoutFullRow);
            layoutBack.addView(rowBorder);
        }
    }
}