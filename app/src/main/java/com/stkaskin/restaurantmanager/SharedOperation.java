package com.stkaskin.restaurantmanager;

import com.google.firebase.firestore.Query;
import com.stkaskin.restaurantmanager.FireCloud.FirebaseService;
import com.stkaskin.restaurantmanager.Models.BigOrder;
import com.stkaskin.restaurantmanager.Models.Table;
import com.stkaskin.restaurantmanager.Perdruable.Data;
import com.stkaskin.restaurantmanager.Perdruable.Page;
import com.stkaskin.restaurantmanager.Perdruable.UpdateData;

import java.util.ArrayList;

public class SharedOperation {
    public static void tableListReset() {
        ArrayList<Table> tb = FirebaseService.Get(Table.class);
        for (Table item : tb) {
            item.setStatus(0);
            FirebaseService.UpdateData(item);
        }
    }

    public static void tableOperation(String tableid) {
        UpdateData.tableUpdate = true;
        Data.table.setStatus(0);

        Table tb = FirebaseService.Get(Table.class, tableid);

        if (tb.getStatus() != 0) {
            tb.setStatus(0);

            FirebaseService.UpdateData(tb);
            Query q = FirebaseService.QueryCreate(BigOrder.class).
                    whereNotEqualTo("tableId", tableid);
            ArrayList<BigOrder> orders = FirebaseService.Get(BigOrder.class, q);
            for (BigOrder bigOrder : orders) {
                bigOrder.setStatus(3);
                bigOrder.setTableId("Old"+tableid);
                FirebaseService.UpdateData(bigOrder);
            }
        } else {
            tb.setStatus(1);
            FirebaseService.UpdateData(tb);

        }
        Page.CloseActivities();
    }
}
