package array.warehouse;

// Imports HashMap for storing data by key
import java.util.HashMap;

// Imports Map interface
import java.util.Map;

public class Warehouse {

    // Stores the single Warehouse object
    private static Warehouse instance;

    // Stores sum for each array by its ID
    private final Map<Integer, Integer> sums = new HashMap<>();

    // Stores average for each array by its ID
    private final Map<Integer, Double> averages = new HashMap<>();

    // Stores minimum value for each array by its ID
    private final Map<Integer, Integer> minimums = new HashMap<>();

    // Stores maximum value for each array by its ID
    private final Map<Integer, Integer> maximums = new HashMap<>();

    // Private constructor prevents creating Warehouse with new
    private Warehouse() {
    }

    // Returns the single Warehouse object
    public static Warehouse getInstance() {

        // Creates Warehouse if it does not exist
        if (instance == null) {
            instance = new Warehouse();
        }

        // Returns the Warehouse object
        return instance;
    }

    // Updates all statistics for an array
    public void update(int id, int sum, double average, int min, int max) {

        // Saves the sum using array ID as the key
        sums.put(id, sum);

        // Saves the average using array ID as the key
        averages.put(id, average);

        // Saves the minimum using array ID as the key
        minimums.put(id, min);

        // Saves the maximum using array ID as the key
        maximums.put(id, max);
    }

    // Returns the sum for the array with the specified ID
    public int getSum(int id) {
        return sums.get(id);
    }

    // Returns the average for the array with the specified ID
    public double getAverage(int id) {
        return averages.get(id);
    }

    // Returns the minimum value for the array with the specified ID
    public int getMin(int id) {
        return minimums.get(id);
    }

    // Returns the maximum value for the array with the specified ID
    public int getMax(int id) {
        return maximums.get(id);
    }
    // Removes all statistics for the specified array
    public void remove(int id) {
        sums.remove(id);
        averages.remove(id);
        minimums.remove(id);
        maximums.remove(id);
    }
}