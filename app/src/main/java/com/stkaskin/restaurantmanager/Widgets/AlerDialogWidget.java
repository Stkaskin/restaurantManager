package com.stkaskin.restaurantmanager.Widgets;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.stkaskin.restaurantmanager.R;

public class AlerDialogWidget {

    public  static  void aa(Context context, DialogInterface.OnClickListener yes, DialogInterface.OnClickListener no){

        AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(
                context);

// Setting Dialog Title
        alertDialog2.setTitle("Confirm Delete...");

// Setting Dialog Message
        alertDialog2.setMessage("Are you sure you want delete this item?");

// Setting Icon to Dialog
        alertDialog2.setIcon(R.drawable.minusbutton);

// Setting Positive "Yes" Btn
        alertDialog2.setPositiveButton("YES", yes);
// Setting Negative "NO" Btn
        alertDialog2.setNegativeButton("NO",no
              );

// Showing Alert Dialog
        alertDialog2.show();


    }
}
