package com.stkaskin.restaurantmanager.Perdruable;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;

public class Page {
    public static ArrayList<Context> contexts = new ArrayList<>();
    public static ArrayList<Intent> intents = new ArrayList<>();
    public static ArrayList<Activity> activities = new ArrayList<>();

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

    public static void addActivity(Activity activity) {
        boolean t = false;
        for (Activity v : activities) {
            if (v.getIntent().getComponent().equals(activity.getIntent().getComponent()))
                t = true;
        }
        if (!t)
            activities.add(activity);
    }
    public static void CloseActivities()
    {
        for (int i=activities.size()-1;i>=0;i--) {
            Activity activity=activities.get(i);
            activity.finish();
            activities.remove(activity);
        }
    }

    public static void IntentRemove(Intent intent) {
        boolean t_ = false;
        for (int i = 0; i < intents.size(); i++) {
            Intent i_ = intents.get(i);
            if (i_.getComponent().equals(intent.getComponent())) {
                {
                    intents.remove(i);
                }

            }
        }


    }

    public static void IntentRemove(int index) {
        if (intents.size() > index)
            intents.remove(index);


    }


}
