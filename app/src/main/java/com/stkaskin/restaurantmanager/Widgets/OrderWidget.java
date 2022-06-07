package com.stkaskin.restaurantmanager.Widgets;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class OrderWidget {
    public static void setOrderLayout(Context context, LinearLayout header, LinearLayout footer, View.OnClickListener listener)
    {
        OrderWidget.HeaderLayout(context,header);
        OrderWidget.FooterLayout(context,footer,listener);
    }
    public static void setOrderLayout(Context context,LinearLayout header,LinearLayout footer)
    {
        OrderWidget.HeaderLayout(context,header);
        OrderWidget.FooterLayout(context,footer,null);
    }
    public static void HeaderLayout(Context context,LinearLayout layoutHeader) {
        LinearLayout layout = new LinearLayout(context);
        layout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        Button btnGeri=new Button(context);
        btnGeri.setText("Geri");
        Button btnIleri=new Button(context);
        btnIleri.setText("İleri");
        layout.addView(btnGeri);
        layout.addView(btnIleri);
        layoutHeader.addView(layout);

    }
    public static void FooterLayout(Context context, LinearLayout layoutFooter, View.OnClickListener listener) {
        LinearLayout layout = new LinearLayout(context);
        Button btnGeri=new Button(context);
        btnGeri.setText("İptal");
        Button btnIleri=new Button(context);
        btnIleri.setText("Siparişi Onayla");
        Button btnOrta=new Button(context);
        btnOrta.setText("Masayı Bitir");
        layout.addView(btnGeri);
        layout.addView(btnOrta);
        layout.addView(btnIleri);
        btnIleri.setOnClickListener(listener);
        layoutFooter.addView(layout);
    }
}
