package array.observer;

import array.entity.IntArray;
import array.warehouse.Warehouse;

public class WarehouseObserver implements ArrayObserver {

    private final Warehouse warehouse = Warehouse.getInstance();

    @Override
    public void update(IntArray array) {

        int[] values = array.getValues();

        int sum = 0;
        int min = values[0];
        int max = values[0];

        for (int value : values) {
            sum += value;

            if (value < min) {
                min = value;
            }

            if (value > max) {
                max = value;
            }
        }

        double average = (double) sum / values.length;

        warehouse.update(array.getId(), sum, average, min, max);
    }
}