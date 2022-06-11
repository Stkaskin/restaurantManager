package com.stkaskin.restaurantmanager.Widgets;

import android.graphics.Color;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableRow;
import android.widget.TextView;

import soup.neumorphism.NeumorphButton;
import soup.neumorphism.NeumorphTextView;

public class ListWidget {
    public static void listWidget(LinearLayout layoutBack, String id, String name, Object tag, View.OnClickListener edit, View.OnClickListener delete)
    {

        LinearLayout row=new LinearLayout(layoutBack.getContext());
        row.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,120));
        row.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout left=new LinearLayout(layoutBack.getContext());
        left.setOrientation(LinearLayout.VERTICAL);
        left.setLayoutParams(new ViewGroup.LayoutParams(860, ViewGroup.LayoutParams.WRAP_CONTENT));
        LinearLayout right=new LinearLayout(layoutBack.getContext());
        NeumorphTextView view=new NeumorphTextView(layoutBack.getContext());
        NeumorphTextView view1=new NeumorphTextView(layoutBack.getContext());
        view.setText(id);
        view1.setText(name);
        left.addView(view);
        left.addView(view1);
        NeumorphButton button=new NeumorphButton(layoutBack.getContext());
        button.setTag(tag);
        button.setText("delete");
        button.setOnClickListener(delete);
        right.addView(button);
        row.addView(left);
        row.addView(right);
        row.setTag(tag);
        row.setOnClickListener(edit);
        TableRow rowBorder = new TableRow(layoutBack.getContext());
        rowBorder.setBackgroundColor(Color.BLACK);
        rowBorder.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 2));
        LinearLayout.LayoutParams p=(LinearLayout.LayoutParams) rowBorder.getLayoutParams();
        p.setMargins(0,30,0,30);

        layoutBack.addView(row);
        layoutBack.addView(rowBorder);
    }
    public static void marginScrollView(ScrollView view)
    {
        LinearLayout.LayoutParams s=(LinearLayout.LayoutParams) view.getLayoutParams();
        s.setMargins(30,0,20,40);
    }
}
