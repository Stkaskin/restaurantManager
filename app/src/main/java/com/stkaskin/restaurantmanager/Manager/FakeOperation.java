package com.stkaskin.restaurantmanager.Manager;

import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.BigOrder;
import com.stkaskin.restaurantmanager.Models.DefaultExtra;
import com.stkaskin.restaurantmanager.Models.Extra;
import com.stkaskin.restaurantmanager.Models.ExtraProduct;
import com.stkaskin.restaurantmanager.Models.Product;
import com.stkaskin.restaurantmanager.Models.detailOrder;

import java.util.ArrayList;
import java.util.Random;

public class FakeOperation {
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
        ArrayList<Extra> extras=FirebaseService.Get(Extra.class);
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
        product.setImageid("https://i20.haber7.net/resize/1300x731//haber/haber7/photos/2019/18/ayranin_faydalari_nelerdir_ramazan_boyu_her_gun_bir_bardak_ayran_icerseniz_1556541192_8748.jpg");
        FirebaseService.Add(product);


    }
}
