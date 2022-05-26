package com.stkaskin.restaurantmanager.Manager;

import com.stkaskin.restaurantmanager.Interface.IManager;
import com.stkaskin.restaurantmanager.Models.Category;

import java.util.ArrayList;

public class CategoryManager implements IManager {

    public ArrayList<Category> get() {
        return addAll();
    }

    public Category setCategory(Category category, Category setCategory) {
        return setProperties(category, setCategory);
    }

    public Category get(String  id) {
        for (Category category : get()) {
            if (category.getId() == id)
                return category;
        }
        return null;
    }

    @Override
    public Object set(Object obj1_old, Object obj_set) {
        return null;
    }

    public ArrayList<Category> setAll(Object obj) {
        ArrayList<Category> list = get();
        ArrayList<Category> categories=(ArrayList<Category>)obj;
        for (int y = 0; y < categories.size(); y++)
            for (int i = 0; i < list.size(); i++)
                if (list.get(i).getId() == categories.get(y).getId())
                    list.set(i, setProperties(list.get(i), categories.get(y)));
        return list;
    }

    private Category setProperties(Category category, Category setCategory) {
        category = setCategory;
        Object a=1;
        a.getClass().getFields();
        return category;
    }

    public ArrayList<Category> addAll() {
        ArrayList<Category> CategoriesList = new ArrayList<>();
        //veritabanı
     /*   CategoriesList.add(new Category("1", "Başlangıç "));
        CategoriesList.add(new Category("2", "Ana Yemek "));
        CategoriesList.add(new Category("3", "Tatlı"));
        CategoriesList.add(new Category("4", "İçicek"));*/
        return CategoriesList;
    }

    @Override
    public Object setProperties(ArrayList<Object> list) {
        return null;
    }
}
