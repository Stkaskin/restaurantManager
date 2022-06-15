package com.stkaskin.restaurantmanager.Views.Order;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.Query;
import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.BigOrder;
import com.stkaskin.restaurantmanager.Models.Extra;
import com.stkaskin.restaurantmanager.Models.ExtraProduct;
import com.stkaskin.restaurantmanager.Models.Model.ExtraModel;
import com.stkaskin.restaurantmanager.Models.Model.SpecialExtraModel;
import com.stkaskin.restaurantmanager.Models.Product;
import com.stkaskin.restaurantmanager.Models.detailOrder;
import com.stkaskin.restaurantmanager.Perdruable.Data;
import com.stkaskin.restaurantmanager.Perdruable.Page;
import com.stkaskin.restaurantmanager.Perdruable.UpdateData;
import com.stkaskin.restaurantmanager.R;
import com.stkaskin.restaurantmanager.SharedOperation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OrderCategoryProductExtras extends AppCompatActivity {

    Product product = new Product();
    ArrayList<ExtraModel> models = new ArrayList<>();
    ArrayList<Button> buttons = new ArrayList<>();
    List<ExtraModel> orijinal = new ArrayList<>();
    LinearLayout layoutBack;
    String productid;
    ArrayList<SpecialExtraModel> extras = new ArrayList<>();

    public void add(String productId) {

        extras = new ArrayList<>();
        product = FirebaseService.Get(Product.class, productId);
        Data.product = product;
        models = new ArrayList<>();
        ArrayList<SpecialExtraModel> mList = new ArrayList<>();


        for (int i = 0; i < product.getExtras().size(); i++) {

            Extra ex = FirebaseService.Get(Extra.class, product.getExtras().get(i).getExtraId());

            SpecialExtraModel sM = new SpecialExtraModel();
            sM.setExtra(ex);
            sM.setValue(product.getExtras().get(i).isDefaultValue());
            if (ex.getStatus() != -1)
                mList.add(sM);
        }
        for (int d = 0; d < mList.size(); d++) {
            ExtraModel mo = new ExtraModel();
            mo.setHeader("" + d);
            String header = "";
            ArrayList<SpecialExtraModel> list = new ArrayList<>();
            list.add(mList.get(d));
            //0 . ile 0 haric karşılaştırma .... 1 den başlar
            for (int i = d + 1; i < mList.size(); i++) {
                if (mList.get(d).getExtra().getType() == (mList.get(i).getExtra().getType())) {
                    list.add(mList.get(i));
                    header = mList.get(i).getExtra().getType() + "";
                    mList.remove(i);
                    i--;
                }

            }
            mo.setHeader("Extra Type Code: " + header + "");
            mo.setExtras(list);
            models.add(mo);
            mList.remove(d);
            d--;

        }


    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void AddOrder(View view) {
        BigOrder order = new BigOrder();
        Query q = FirebaseService.QueryCreate(BigOrder.class);
        q = q.whereEqualTo("tableId", Data.table.getId().trim());
        boolean update = false;//add
        ArrayList<BigOrder> orders = FirebaseService.Get(BigOrder.class, q);
        if (orders != null && orders.size() > 0 && Data.table.getStatus() != 0) {
            for (int i = 0; i < orders.size(); i++) {
                if (orders.get(i).getStatus() != 3) {
                    order = orders.get(i);
                    break;
                }
            }
            update = true;//update
        } else
            order = new BigOrder();
        order.setWaiterId("xWaiter");
        order.setCheffId("xCheff");
        order.setDatetime(LocalDateTime.now().toString());
        order.setNote("description");
        order.setTableId(Data.table.getId());
        ArrayList<ExtraProduct> extraProducts = getDetail();
        ArrayList<detailOrder> detailOrderArrayList = order.getOrders();
        detailOrder detailOrder = new detailOrder();
        detailOrder.setProductId(productid);
        detailOrder.setPrice(product.getPrice());
        detailOrder.setCount(1);
        detailOrderArrayList.add(detailOrder);
        order.setOrders(detailOrderArrayList);
        detailOrder.setExtras(extraProducts);
        //product var ise count artılacak
        if (update)
            FirebaseService.UpdateData(order);
        else
            FirebaseService.Add(order);
        Data.table.setStatus(1);
        FirebaseService.UpdateData(Data.table);

        Toast.makeText(this, "Eklendi", Toast.LENGTH_SHORT).show();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        UpdateData.tableProductUpdate = true;
        UpdateData.tableUpdate = true;
        finish();


    }

    private ArrayList<ExtraProduct> getDetail() {
        ArrayList<ExtraProduct> extraProducts = new ArrayList<>();
        for (Button button : buttons) {
            SpecialExtraModel bt = (SpecialExtraModel) button.getTag();
            ExtraProduct p = new ExtraProduct();
            p.setExtraid(bt.getExtra().getId());
            p.setSelect(bt.isValue());
            p.setGrpName("none");
            extraProducts.add(p);
        }
        return extraProducts;
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_category_product_extras);
        Page.addActivity(this);
        //   OrderWidget.setOrderLayout(this, findViewById(R.id.OrderHeader_Extra), findViewById(R.id.OrderFooter_Extra), view -> {
        //      AddOrder();
        //     });
        layoutBack = findViewById(R.id.linearLayoutCategoryProductExtras);
        productid = getIntent().getStringExtra("ProductId");
        add(productid);
        getExtras();


    }

    public void getExtras() {
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
            for (int i = 0; i < item.getExtras().size(); i++) {
                Button button = new Button(this);
                //statü kontrolüne göre renk verilecek

                button.setBackgroundColor(Color.TRANSPARENT);
                button.setText(item.getExtras().get(i).getExtra().getName());
                button.setTag(item.getExtras().get(i));
                if (!item.getExtras().get(i).isValue())
                    button.setBackgroundColor(Color.TRANSPARENT);
                else
                    button.setBackgroundColor(Color.GREEN);

                button.setOnClickListener(view ->
                {
                    SpecialExtraModel m = (SpecialExtraModel) view.getTag();
                    if (((ColorDrawable) view.getBackground()).getColor() == Color.TRANSPARENT) {
                        view.setBackgroundColor(Color.GREEN);

                        m.setValue(true);
                        view.setTag(m);
                    } else {
                        view.setBackgroundColor(Color.TRANSPARENT);

                        //   m.getDetail().setStatus();
                        m.setValue(false);
                        view.setTag(m);
                    }
                });
                if (i % 2 == 0)
                    row1.addView(button);
                else
                    row2.addView(button);
                buttons.add(button);
            }

            layoutRow.addView(row1);
            layoutRow.addView(row2);
            TableRow rowBorder = new TableRow(this);
            rowBorder.setBackgroundColor(Color.BLACK);
            rowBorder.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 2));
            TextView view = new TextView(this);
            view.setText(item.getHeader() + "");
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

    public void Back(View view) {
        finish();
    }

    public void BackAll(View view) {
        Page.CloseActivities();
    }

    public void tableOperation(View view
    ) {
        SharedOperation.tableOperation(Data.table.getId());
    }
}