package com.stkaskin.restaurantmanager.FireCloud;


import android.annotation.SuppressLint;
import android.util.Log;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class FirebaseService {
    private  static  FirebaseFirestore db = FirebaseFirestore.getInstance();
    public static <T> ArrayList<T> ReadData(T obj) {

        String tablename = DataService.TableNameGet(obj);
        ArrayList<T> arrayList = new ArrayList<>();
        return SearchCustom(obj, db.collection(tablename));


    }

    public static <T> T ReadDataWhereDocumentId(T obj, String id) {
        Task<DocumentSnapshot> task =db.collection("Table").document(id).get();
        for (int i = 0; i < 150; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (task.isSuccessful()) {
                Log.d("TAMAMLANDI", "TAMAMLANDI");
                return DataService.ConvertData(obj, task.getResult());

            } else if (task.isCanceled()) {
                Log.d("Error", "Error");
                break;
            } else if (task.isComplete()) {

                Log.d("Bitti", "Bitti");
                return DataService.ConvertData(obj, task.getResult());

            }

        }
        return null;


    }

    public static <T> ArrayList<T> SearchCustom(T obj, Query query) {
        Task<QuerySnapshot> task = query.get();
        ArrayList<T> arrayList = new ArrayList<>();
        for (int i = 0; i < 150; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (task.isSuccessful()) {
                Log.d("TAMAMLANDI", "TAMAMLANDI");
                arrayList = DataService.ConvertData(obj, task.getResult().getDocuments());
                return arrayList;
            } else if (task.isCanceled()) {
                Log.d("Error", "Error");
                break;
            } else if (task.isComplete()) {
                task.getResult();
                Log.d("Bitti", "Bitti");
                break;
            }

        }
        return DataService.ConvertData(obj, task.getResult().getDocuments());

    }

    public static Query QueryCustom(Object obj) {
        String tablename = DataService.TableNameGet(obj);
        return db.collection(tablename);

    }

    public static <T> ArrayList<T> SearchFields(T obj, Map<String, Object> values) {
        Query query = db.collection("");
        for (Map.Entry<String, Object> entry : values.entrySet()) {
            query = query.whereEqualTo(entry.getKey(), entry.getValue());
        }


        return DataService.ConvertData(obj, query.get().getResult().getDocuments());

    }

    public static <T> ArrayList<T> ReadDatas(T obj) {


        String tablename = DataService.TableNameGet(obj);
        ArrayList<T> arrayList = new ArrayList<>();
        Task<QuerySnapshot> task = db.collection(tablename)
                .get();
        for (int i = 0; i < 150; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (task.isSuccessful()) {
                Log.d("TAMAMLANDI", "TAMAMLANDI");
                arrayList = DataService.ConvertData(obj, task.getResult().getDocuments());
                return arrayList;

            } else if (task.isCanceled()) {
                Log.d("Error", "Error");
                break;
            } else if (task.isComplete()) {
                Log.d("Bitti", "Bitti");
                arrayList = DataService.ConvertData(obj, task.getResult().getDocuments());
                return arrayList;

            }

        }

        return new ArrayList<T>();
    }


    public static <T> String AddData(T obj) {

        Map<String, Object> data = DataService.ConvertDataForObjectList(obj);
        String tablename = DataService.TableNameGet(obj);
// Add a new document with a generated ID
        Task<DocumentReference> referenceTask = db.collection(tablename).add(data);
        String id = "";
        for (int i = 0; i < 50; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (referenceTask.isSuccessful()) {
                Log.d("Eklendi", referenceTask.getResult().getId());
                id = referenceTask.getResult().getId();
                return referenceTask.getResult().getId();

            } else if (referenceTask.isComplete()) {
                Log.d("Tamamlandı", referenceTask.getResult().getId());
                id = referenceTask.getResult().getId();
                return referenceTask.getResult().getId();
            }
        }
        return id;
    }


    @SuppressLint("NewApi")
    public static boolean UpdateData(Object obj) {

        String documentId = DataService.getIdData(obj);
        if (documentId.length() < 1) {
            Log.d("Update", "Failed The Update Operation Need id field ,getId method and  setId method");
            return false;
        }


        Map<String, Object> data = DataService.ConvertDataForObjectList(obj);
        Map<String, Object> dataf = new HashMap<>();
        dataf.putAll(data);
        for (Map.Entry<String, Object> entry : dataf.entrySet())
            if (entry.getValue() == null)
                data.remove(entry.getKey(), entry.getValue());

        String tablename = DataService.TableNameGet(obj);
        Task<Void> referenceTask = db.collection(tablename).document(documentId).update(data);
        for (int i = 0; i < 50; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (referenceTask.isSuccessful()) {
                Log.d("Update", "Succesful");
                return true;

            } else if (referenceTask.isComplete()) {
                Log.d("Update", "Complate");
                return true;
            }

        }
        return false;
    }

    public static boolean DeleteData(Object obj) {
        String documentId = DataService.getIdData(obj);
        if (documentId.length() < 1) {
            Log.d("Update", "Failed The Update Operation Need id field ,getId method and  setId method");
            return false;
        }
        String tablename = DataService.TableNameGet(obj);


        Task<Void> referenceTask = db.collection(tablename).document(documentId).delete();
        return true;
    }


}