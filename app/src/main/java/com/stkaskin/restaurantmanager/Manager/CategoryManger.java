package com.stkaskin.restaurantmanager.Manager;

import com.stkaskin.restaurantmanager.Models.Category;

import java.util.ArrayList;

public class CategoryManger {

    public ArrayList<Category> getAllCategories() {
        return addAllCategories();
    }

    public Category setCategory(Category category, Category setCategory) {
        return setCategoryProperties(category, setCategory);
    }
    public Category search(int id)
    {
        for (Category category: getAllCategories()) {
            if (category.getId()==id)
                return category;
        }
        return null;
    }

    public ArrayList<Category> setAllCategories(ArrayList<Category> categories) {
        ArrayList<Category> list = getAllCategories();
        for (int y = 0; y < categories.size(); y++)
            for (int i = 0; i < list.size(); i++)
                if (list.get(i).getId() == categories.get(y).getId())
                    list.set(i, setCategoryProperties( list.get(i),categories.get(y)));
        return list;
    }
    private Category setCategoryProperties(Category category, Category setCategory) {
        category = setCategory;
        return category;
    }
    private ArrayList<Category> addAllCategories() {
        ArrayList<Category> CategoriesList = new ArrayList<>();
        //veritabanı
        CategoriesList.add(new Category(1, "Başlangıç "));
        CategoriesList.add(new Category(2, "Ana Yemek "));
        CategoriesList.add(new Category(3, "Tatlı"));
        CategoriesList.add(new Category(4, "İçicek"));
        return CategoriesList;
    }
}
