package com.kachanova.array.warehouse;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {

    private static Warehouse instance;

    private final Map<Integer, ArrayStatistics> statistics = new HashMap<>();

    // Prevents creating multiple Warehouse objects
    private Warehouse() {
    }

    // Returns the single Warehouse object
    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    // Updates statistics for an array
    public void update(int id, int[] values) {
        statistics.put(id, new ArrayStatistics(values));
    }

    // Returns the sum
    public int getSum(int id) {
        return statistics.get(id).getSum();
    }

    // Returns the average
    public double getAverage(int id) {
        return statistics.get(id).getAverage();
    }

    // Returns the minimum
    public int getMin(int id) {
        return statistics.get(id).getMin();
    }

    // Returns the maximum
    public int getMax(int id) {
        return statistics.get(id).getMax();
    }

    // Removes statistics for an array
    public void remove(int id) {
        statistics.remove(id);
    }
}
