package com.stkaskin.restaurantmanager.Views.Order;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.stkaskin.restaurantmanager.R;

public class Order extends AppCompatActivity {

    //Adım1 masalar gelecek durumu aktif pasif hazırlanıyorlar gelecek
    //Adım2 secilen masa gelecek bilgileri ile
    //Adım2.1 Secilen Masanın ürün bilgileri
    //Adım2.2 masanın ekleme silme edit sipariş tamamla sipariş iptal buttonları eklenecek
    //Adım2.3 Masanın silme olayı azaltma ve silme olayı gerçekleştirecek
    //Adım2.4 masanın edit olayı ürünün içerik bilgi sayfasında seçim bölmesine atacak
    //Adım2.5 masanın sipariş iptal tuşu siparişi iptal edecek bir adet alertDioalog gelecek
    //Adım2.6 masanın sipariş ekle buttonu sipariş ekleme işinin bittiği anlamına gelecek ve buradan ilgili birimlere aktaracak
    //Adım3 Masadaki ekle buttonu katagoriye atacak ve Kategoriler gelecek
    //Adım4 secilen kategorinin ürünleri gelecek
    //Adım5 Secilen ürünün 3 blok halinde bilgileri gelecek
    //ADIM6 Secilen ürünün girilen detaylarından sonra ekleme işlemi bitecek ve tekrar aynı kategorinin ürün sayfasına atacak
    //Tekrarlama

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
    }
}