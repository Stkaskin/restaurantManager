package com.stkaskin.restaurantmanager.Interface;

import com.stkaskin.restaurantmanager.Models.Category;

import java.util.ArrayList;

public interface IManager {
    Object addAll ();
    Object  setProperties(ArrayList<Object> list);
    Object get ();
    Object  get (String obj );
    Object    set(Object obj1_old,Object obj_set);
}
