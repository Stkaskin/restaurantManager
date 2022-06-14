package com.stkaskin.restaurantmanager.Manager;

import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.BigOrder;
import com.stkaskin.restaurantmanager.Models.Category;
import com.stkaskin.restaurantmanager.Models.DefaultExtra;
import com.stkaskin.restaurantmanager.Models.Extra;
import com.stkaskin.restaurantmanager.Models.ExtraProduct;
import com.stkaskin.restaurantmanager.Models.Product;
import com.stkaskin.restaurantmanager.Models.Table;
import com.stkaskin.restaurantmanager.Models.detailOrder;

import java.util.ArrayList;
import java.util.Random;

public class FakeOperation {
    ArrayList<Product> products = new ArrayList<>();
    public static ArrayList<Extra> extras = new ArrayList<>();
    static ArrayList<String> stringsExtras = new ArrayList<>();
    static ArrayList<String> idExtra = new ArrayList();

    public static void setStatusTable()
    {
    ArrayList<Table> list2 = FirebaseService.Get(Table.class);
        for (Table extra:list2) {
            extra.setStatus(0);
            FirebaseService.UpdateData(extra);
        }
    }
    public static void setStatus() {
        ArrayList<Extra> list = FirebaseService.Get(Extra.class);
        for (Extra extra:list) {
            extra.setStatus(1);
            FirebaseService.UpdateData(extra);
        }
        ArrayList<Category> list1 = FirebaseService.Get(Category.class);
        for (Category extra:list1) {
            extra.setStatus(1);
            FirebaseService.UpdateData(extra);
        }
        ArrayList<Table> list2 = FirebaseService.Get(Table.class);
        for (Table extra:list2) {
            extra.setStatus(0);
            FirebaseService.UpdateData(extra);
        }
        ArrayList<Product> list3 = FirebaseService.Get(Product.class);
        for (Product extra:list3) {
            extra.setStatus(1);
            FirebaseService.UpdateData(extra);
        }
    }

    public static void setExtras1() {
        //0
        stringsExtras.add("Turşu");
        stringsExtras.add("Patates kızartması");
        stringsExtras.add("Chedar Peyniri");
        stringsExtras.add("Soğan");
        stringsExtras.add("Sarımsak");
        stringsExtras.add("Domates");
        stringsExtras.add("Yoğurt");
        stringsExtras.add("Maydonoz");
        //1
        stringsExtras.add("Tek Lavaş");
        stringsExtras.add("Çift Lavaş");
        //2
        stringsExtras.add("Lavaş");
        stringsExtras.add("Pide");
        stringsExtras.add("Somun");
        //3
        stringsExtras.add("Mayonez");
        stringsExtras.add("Ketcap");
        stringsExtras.add("Sos");
        //4
        stringsExtras.add("Tuz");
        stringsExtras.add("Pul Biber");


        int tt = 0;
        for (int i = 0; i < stringsExtras.size(); i++) {
            Extra extra = new Extra();
            extra.setName(stringsExtras.get(i));
            if (i < 8) {
                extra.setType(0);
            } else if (i < 10) {
                extra.setType(1);

            } else if (i < 13) {
                extra.setType(2);

            } else {
                extra.setType(3);

            }
            idExtra.add(FirebaseService.Add(extra));
        }


    }

    public static void setExtras() {
        stringsExtras.add("Açık");
        stringsExtras.add("Kapalı");
        stringsExtras.add("330 Ml");
        stringsExtras.add("1 Lt");
        stringsExtras.add("1.5 Lt");
        stringsExtras.add("2 Lt");
        stringsExtras.add("2.5 Lt");
        for (int i = 0; i < stringsExtras.size(); i++) {
            Extra extra = new Extra();
            extra.setName(stringsExtras.get(i));
            if (i < 2) {
                extra.setType(11);
            } else {
                extra.setType(12);

            }
            idExtra.add(FirebaseService.Add(extra));
        }
        ProductsAdd();

    }

    public static void ProductsAdd() {
        ArrayList<String> productsName = new ArrayList<>();
        productsName.add("Ayran ");
        productsName.add("Su");
        productsName.add("Kola");
        productsName.add("Şalgam");
        productsName.add("Sprite");
        productsName.add("Fanta");
        ArrayList<DefaultExtra> extrasdefault = new ArrayList<>();


        for (int i = 0; i < productsName.size(); i++) {
            Product product = new Product();
            extrasdefault = new ArrayList<>();
            for (int c = 0; c < idExtra.size(); c++) {
                DefaultExtra extra = new DefaultExtra();
                extra.setDefaultValue(new Random().nextBoolean());
                extra.setExtraId(idExtra.get(i));
                extrasdefault.add(extra);
            }
            product.setExtras(extrasdefault);
            product.setName(productsName.get(i));
            product.setDescription("Des " + i);
            product.setPrice(new Random().nextInt(500));
            product.setImageid("");
            product.setStatus(1);
            product.setDisplayRank(999);
            product.setCategoryId("InNVM3q7EFDzR3Zzvn18");
            FirebaseService.Add(product);
        }
    }

    public static void addBigOrder() {
        ArrayList<Extra> extras = FirebaseService.Get(Extra.class);

        ArrayList<Product> products = FirebaseService.Get(Product.class);
        ArrayList<detailOrder> orders = new ArrayList<>();

        for (int d = 0; d < products.size() && d < 4; d++) {
            detailOrder detailOrder = new detailOrder();
            detailOrder.setExtras(new ArrayList<ExtraProduct>());
            detailOrder.setCount(new Random().nextInt(5));
            detailOrder.setPrice(new Random().nextInt(200));


            for (int i = 0; i < extras.size() && i < 6; i++) {
                ExtraProduct extraProduct = new ExtraProduct();
                extraProduct.setGrpName(i + "");
                extraProduct.setSelect(new Random().nextBoolean());
                extraProduct.setExtraid(extras.get(i).getId());
                detailOrder.getExtras().add(extraProduct);

            }
            orders.add(detailOrder);
        }


        BigOrder order = new BigOrder();
        order.setOrders(orders);
        FirebaseService.Add(order);

    }

    public static void addProduct() {
    /*    ArrayList<Extra> extras =new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            Extra extra=new Extra();
            extra.setType(i+"");
            extra.setName("yeni extra"+i);
            extra.setId(FirebaseService.Add(extra));
            extras.add(extra);

        }*/
        ArrayList<Extra> extras = FirebaseService.Get(Extra.class);
        Product product = new Product();
        DefaultExtra extra = new DefaultExtra();
        ArrayList<DefaultExtra> defaultExtras = new ArrayList<>();
        for (int i = 0; i < extras.size() && i < 5; i++) {
            extra = new DefaultExtra();
            extra.setExtraId(extras.get(i).getId());
            extra.setDefaultValue(new Random().nextBoolean());
            defaultExtras.add(extra);
        }
        product.setExtras(defaultExtras);
        product.setName("new urun");
        product.setCategoryId("InNVM3q7EFDzR3Zzvn18");
        product.setDisplayRank(5);
        product.setDescription("yok");

        FirebaseService.Add(product);


    }
}
