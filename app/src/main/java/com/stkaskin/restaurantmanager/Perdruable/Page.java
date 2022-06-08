package com.stkaskin.restaurantmanager.Perdruable;

import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;

public class Page {
    public static ArrayList<Context> contexts = new ArrayList<>();
    public static ArrayList<Intent> intents = new ArrayList<>();

    public static Intent IntentGet(Intent intent) {
        boolean t_ = false;
        for (Intent i_ : intents) {
            if (i_.getComponent().equals(intent.getComponent())) {
                return intent;

            }
        }
        intents.add(intent);
        return intent;
    }


}
