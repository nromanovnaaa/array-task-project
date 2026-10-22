
package com.kachanova.array.observer;

import com.kachanova.array.entity.IntArray;
import com.kachanova.array.warehouse.Warehouse;

public class WarehouseObserver implements ArrayObserver {

    private final Warehouse warehouse = Warehouse.getInstance();

    // Updates statistics when an array changes
    @Override
    public void update(IntArray array) {
        warehouse.update(array.getId(), array.getValues());
    }
}
