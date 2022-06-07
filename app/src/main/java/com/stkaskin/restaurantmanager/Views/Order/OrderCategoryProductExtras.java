package com.stkaskin.restaurantmanager.Views.Order;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
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

import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.Extra;
import com.stkaskin.restaurantmanager.Models.ExtraDetail;
import com.stkaskin.restaurantmanager.Models.Model.ExtraAndDetailModel;
import com.stkaskin.restaurantmanager.Models.Model.ExtraModel;
import com.stkaskin.restaurantmanager.Models.Order;
import com.stkaskin.restaurantmanager.Models.OrderDetail;
import com.stkaskin.restaurantmanager.Models.Product;
import com.stkaskin.restaurantmanager.Models.SpecialExtraList;
import com.stkaskin.restaurantmanager.R;
import com.stkaskin.restaurantmanager.Widgets.OrderWidget;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderCategoryProductExtras extends AppCompatActivity {

    Product product = new Product();
    ArrayList<ExtraModel> models = new ArrayList<>();
    ArrayList<Button> buttons = new ArrayList<>();
    List<ExtraModel> orijinal = new ArrayList<>();

    public void add(String productId) {

        product = FirebaseService.Get(Product.class, productId);
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

        for (ExtraModel model : models) {
            ExtraModel m = new ExtraModel();

            m.setModels(model.getModels());
            orijinal.add(m);


        }
    }

    /*
    the command change product extra
        public void aa(View view) {
            ArrayList<ExtraDetail> updateDetails = new ArrayList<>();
            for (ExtraModel model : models) {
                for (ExtraAndDetailModel detail : model.getModels()) {
                    for (Button bt : buttons) {
                        ExtraAndDetailModel m = (ExtraAndDetailModel) bt.getTag();
                        if (m.getDetail().getId().equals(detail.getDetail().getId()) && m.getDetail().getStatus() != detail.getDetail().getStatus()) {
                            updateDetails.add(m.getDetail());
                            break;
                        }
                    }
                }
            }
            for (ExtraDetail detail:updateDetails           ) {
                FirebaseService.UpdateData(detail);
            }

            Toast.makeText(this, obj, Toast.LENGTH_SHORT).show();

        }
    */
    String obj = "1sadsa";

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void AddOrder() {
        Order order = new Order();
        order.setCheffId("WTRvTZA6Z6aFwZJPz9X1");
        order.setWaiterId("LjVd7KQs6ffwDIkK8NWy");
        order.setTableId("CV39OweT7xiQWIu80lgS");
        order.setStatus(0);
        order.setNote("None");
        order.setDatetime(LocalDateTime.now() + "");
        order.setTotal(0);
        order.setSpecialExtraListId("");
        String id = FirebaseService.Add(order);
        if (id != null) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setStatus(0);
            orderDetail.setCount(5);
            orderDetail.setPrice(5);
            orderDetail.setOrderid(id);
            orderDetail.setProductid(productid);
            orderDetail.setSum(25);

            String orderDetailId = FirebaseService.Add(orderDetail);
            ArrayList<ExtraDetail> updateDetails = new ArrayList<>();
            boolean change = false;
            for (ExtraModel model : orijinal) {
                for (ExtraAndDetailModel detail : model.getModels()) {
                    for (Button bt : buttons) {
                        ExtraAndDetailModel m = (ExtraAndDetailModel) bt.getTag();
                        if (m.getDetail().getId().equals(detail.getDetail().getId())) {

                            change = true;
                            break;
                        }
                    }
                    if (change)
                        break;
                }
                if (change)
                    break;
            }
            String st = "";
            if (change) {
                SpecialExtraList list = new SpecialExtraList();
                list.setDisplayRank(999);
                list.setStatus(9);
                list.setName("Custom");
                st = FirebaseService.Add(list);
                for (Button bt : buttons) {
                    ExtraAndDetailModel m = (ExtraAndDetailModel) bt.getTag();
                    m.getDetail().setSpecialExtraListId(st);
                    FirebaseService.Add(m.getDetail());
                }

            } else {
                if (buttons.size() > 0) {
                    ExtraAndDetailModel m = (ExtraAndDetailModel) buttons.get(0).getTag();
                    st = m.getDetail().getSpecialExtraListId();
                }
            }
            //    orderDetail.setOrderid(orderDetailId);
//            orderDetail.set
            order.setId(id);
            order.setSpecialExtraListId(st);
            FirebaseService.UpdateData(order);

        }
        Toast.makeText(this, "Sipariş Eklendi", Toast.LENGTH_SHORT).show();
        try {
            Thread.sleep(1000);
            finish();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    String productid;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_category_product_extras);
        OrderWidget.setOrderLayout(this, findViewById(R.id.OrderHeader_Extra), findViewById(R.id.OrderFooter_Extra), view -> {
            AddOrder();
        });
        LinearLayout layoutBack = findViewById(R.id.linearLayoutCategoryProductExtras);
        productid = getIntent().getStringExtra("ProductId");
        add(productid);
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
                Button button = new Button(this);
                //statü kontrolüne göre renk verilecek
                button.setBackgroundColor(Color.TRANSPARENT);
                button.setText(item.getModels().get(i).getExtra().getName());
                button.setTag(item.getModels().get(i));
                if (item.getModels().get(i).getDetail().getStatus() == 0)
                    button.setBackgroundColor(Color.TRANSPARENT);
                else
                    button.setBackgroundColor(Color.GREEN);

                button.setOnClickListener(view ->
                {
                    if (((ColorDrawable) view.getBackground()).getColor() == Color.TRANSPARENT) {
                        view.setBackgroundColor(Color.GREEN);
                        ExtraAndDetailModel m = (ExtraAndDetailModel) view.getTag();
                        m.getDetail().setStatus(1);
                        view.setTag(m);
                    } else {
                        view.setBackgroundColor(Color.TRANSPARENT);
                        ExtraAndDetailModel m = (ExtraAndDetailModel) view.getTag();
                     //   m.getDetail().setStatus();
                        m.getDetail().setStatus(0);
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


}