package com.stkaskin.restaurantmanager.Widgets;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.stkaskin.restaurantmanager.R;

public class AlerDialogWidget {
    public static String title="Silmeyi Onaylayın.!.";
    public static String default_title="Silmeyi Onaylayın.!.";
    public static String description="Seçili Öğeyi Silmek İstediğinize Emin Misiniz?";
    public static String default_description="Seçili Öğeyi Silmek İstediğinize Emin Misiniz?";
    public  static String yes_="SİL";
    public  static String no_="İPTAL";
    public  static String default_yes="SİL";
    public  static String default_no="Iptal";

    public  static  void aa(Context context, DialogInterface.OnClickListener yes, DialogInterface.OnClickListener no){

        AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(
                context);

// Setting Dialog Title
        alertDialog2.setTitle(title);

// Setting Dialog Message
        alertDialog2.setMessage(description);

// Setting Icon to Dialog
        alertDialog2.setIcon(R.drawable.minusbutton);

// Setting Positive "Yes" Btn
        alertDialog2.setPositiveButton(yes_, yes);
// Setting Negative "NO" Btn
        alertDialog2.setNegativeButton(no_,no
              );

// Showing Alert Dialog
        alertDialog2.show();


    }
}
