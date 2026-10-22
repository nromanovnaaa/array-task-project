package com.kachanova.array.repository;

import com.kachanova.array.entity.IntArray;
import com.kachanova.array.observer.ArrayObserver;
import com.kachanova.array.observer.WarehouseObserver;
import com.kachanova.array.warehouse.Warehouse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArrayRepository {

    private static ArrayRepository instance;

    private final List<IntArray> arrays = new ArrayList<>();
    private final List<ArrayObserver> observers = new ArrayList<>();

    private ArrayRepository() {
        addObserver(new WarehouseObserver());
    }

    // Returns the single Repository object
    public static ArrayRepository getInstance() {
        if (instance == null) {
            instance = new ArrayRepository();
        }

        return instance;
    }

    // Adds an array and updates its statistics in Warehouse
    public void add(IntArray array) {
        arrays.add(array);
        notifyObservers(array);
    }

    // Removes an array and its statistics
    public void remove(IntArray array) {
        if (arrays.remove(array)) {
            Warehouse warehouse = Warehouse.getInstance();
            warehouse.remove(array.getId());
        }
    }

    // Returns all arrays without exposing the internal list
    public List<IntArray> getAll() {
        return new ArrayList<>(arrays);
    }

    // Finds an array by its ID
    public IntArray findById(int id) {
        for (IntArray array : arrays) {
            if (array.getId() == id) {
                return array;
            }
        }

        return null;
    }


    // Finds arrays with the specified sum
    public List<IntArray> findBySum(int sum) {
        List<IntArray> result = new ArrayList<>();

        for (IntArray array : arrays) {
            int[] values = array.getValues();
            int total = calculateSum(values);

            if (total == sum) {
                result.add(array);
            }
        }

        return result;
    }

    // Finds arrays with the specified maximum value
    public List<IntArray> findByMax(int max) {
        List<IntArray> result = new ArrayList<>();

        for (IntArray array : arrays) {
            int[] values = array.getValues();

            if (values.length == 0) {
                continue;
            }

            int currentMax = findMaximumValue(values);

            if (currentMax == max) {
                result.add(array);
            }
        }

        return result;
    }

    // Finds arrays with the specified minimum value
    public List<IntArray> findByMin(int min) {
        List<IntArray> result = new ArrayList<>();

        for (IntArray array : arrays) {
            int[] values = array.getValues();

            if (values.length == 0) {
                continue;
            }

            int currentMin = findMinimumValue(values);

            if (currentMin == min) {
                result.add(array);
            }
        }

        return result;
    }

    // Finds arrays with the specified average
    public List<IntArray> findByAverage(double average) {
        List<IntArray> result = new ArrayList<>();

        for (IntArray array : arrays) {
            int[] values = array.getValues();

            if (values.length == 0) {
                continue;
            }

            double currentAverage = calculateAverageValue(values);

            if (currentAverage == average) {
                result.add(array);
            }
        }

        return result;
    }

    // Finds arrays containing the specified element
    public List<IntArray> findByElement(int element) {
        List<IntArray> result = new ArrayList<>();

        for (IntArray array : arrays) {
            int[] values = array.getValues();

            for (int value : values) {
                if (value == element) {
                    result.add(array);
                    break;
                }
            }
        }

        return result;
    }

    // Finds arrays whose sum is greater than the given value
    public List<IntArray> findBySumGreaterThan(int sum) {
        List<IntArray> result = new ArrayList<>();

        for (IntArray array : arrays) {
            int[] values = array.getValues();
            int total = calculateSum(values);

            if (total > sum) {
                result.add(array);
            }
        }

        return result;
    }

    // Finds arrays whose sum is less than the given value
    public List<IntArray> findBySumLessThan(int sum) {
        List<IntArray> result = new ArrayList<>();

        for (IntArray array : arrays) {
            int[] values = array.getValues();
            int total = calculateSum(values);

            if (total < sum) {
                result.add(array);
            }
        }

        return result;
    }

    // Finds arrays whose maximum is greater than the given value
    public List<IntArray> findByMaxGreaterThan(int max) {
        List<IntArray> result = new ArrayList<>();

        for (IntArray array : arrays) {
            int[] values = array.getValues();

            if (values.length == 0) {
                continue;
            }

            int currentMax = findMaximumValue(values);

            if (currentMax > max) {
                result.add(array);
            }
        }

        return result;
    }

    // Finds arrays whose maximum is less than the given value
    public List<IntArray> findByMaxLessThan(int max) {
        List<IntArray> result = new ArrayList<>();

        for (IntArray array : arrays) {
            int[] values = array.getValues();

            if (values.length == 0) {
                continue;
            }

            int currentMax = findMaximumValue(values);

            if (currentMax < max) {
                result.add(array);
            }
        }

        return result;
    }

    // Finds arrays whose minimum is greater than the given value
    public List<IntArray> findByMinGreaterThan(int min) {
        List<IntArray> result = new ArrayList<>();

        for (IntArray array : arrays) {
            int[] values = array.getValues();

            if (values.length == 0) {
                continue;
            }

            int currentMin = findMinimumValue(values);

            if (currentMin > min) {
                result.add(array);
            }
        }

        return result;
    }

    // Finds arrays whose minimum is less than the given value
    public List<IntArray> findByMinLessThan(int min) {
        List<IntArray> result = new ArrayList<>();

        for (IntArray array : arrays) {
            int[] values = array.getValues();

            if (values.length == 0) {
                continue;
            }

            int currentMin = findMinimumValue(values);

            if (currentMin < min) {
                result.add(array);
            }
        }

        return result;
    }

    // Finds arrays whose average is greater than the given value
    public List<IntArray> findByAverageGreaterThan(double average) {
        List<IntArray> result = new ArrayList<>();

        for (IntArray array : arrays) {
            int[] values = array.getValues();

            if (values.length == 0) {
                continue;
            }

            double currentAverage = calculateAverageValue(values);

            if (currentAverage > average) {
                result.add(array);
            }
        }

        return result;
    }

    // Finds arrays whose average is less than the given value
    public List<IntArray> findByAverageLessThan(double average) {
        List<IntArray> result = new ArrayList<>();

        for (IntArray array : arrays) {
            int[] values = array.getValues();

            if (values.length == 0) {
                continue;
            }

            double currentAverage = calculateAverageValue(values);

            if (currentAverage < average) {
                result.add(array);
            }
        }

        return result;
    }

    // Finds arrays with the specified number of elements
    public List<IntArray> findBySize(int size) {
        List<IntArray> result = new ArrayList<>();

        for (IntArray array : arrays) {
            int[] values = array.getValues();

            if (values.length == size) {
                result.add(array);
            }
        }

        return result;
    }

    // Finds arrays containing more elements than the given number
    public List<IntArray> findBySizeGreaterThan(int size) {
        List<IntArray> result = new ArrayList<>();

        for (IntArray array : arrays) {
            int[] values = array.getValues();

            if (values.length > size) {
                result.add(array);
            }
        }

        return result;
    }

    // Finds arrays containing fewer elements than the given number
    public List<IntArray> findBySizeLessThan(int size) {
        List<IntArray> result = new ArrayList<>();

        for (IntArray array : arrays) {
            int[] values = array.getValues();

            if (values.length < size) {
                result.add(array);
            }
        }

        return result;
    }

    // Sorts arrays by ID in ascending order
    public List<IntArray> sortById() {
        List<IntArray> result = new ArrayList<>(arrays);

        result.sort(Comparator.comparingInt(IntArray::getId));

        return result;
    }

    // Sorts arrays by their number of elements
    public List<IntArray> sortBySize() {
        List<IntArray> result = new ArrayList<>(arrays);

        result.sort(Comparator.comparingInt(
                array -> array.getValues().length
        ));

        return result;
    }

    // Sorts arrays by their first element
    // Empty arrays are placed first
    public List<IntArray> sortByFirstElement() {
        List<IntArray> result = new ArrayList<>(arrays);

        result.sort(Comparator.comparingInt(array -> {
            int[] values = array.getValues();

            if (values.length == 0) {
                return Integer.MIN_VALUE;
            }

            return values[0];
        }));

        return result;
    }

    // Sorts arrays by their maximum value
    // Empty arrays are placed first
    public List<IntArray> sortByMax() {
        List<IntArray> result = new ArrayList<>(arrays);

        result.sort(Comparator.comparingInt(array -> {
            int[] values = array.getValues();

            if (values.length == 0) {
                return Integer.MIN_VALUE;
            }

            return findMaximumValue(values);
        }));

        return result;
    }

    // Registers an observer
    public void addObserver(ArrayObserver observer) {
        observers.add(observer);
    }

    // Notifies all registered observers about an array change
    private void notifyObservers(IntArray array) {
        for (ArrayObserver observer : observers) {
            observer.update(array);
        }
    }


    // Changes an element and updates the array statistics
    public void updateElement(int id, int index, int value) {
        for (IntArray array : arrays) {
            if (array.getId() == id) {
                array.setValue(index, value);
                notifyObservers(array);
                break;
            }
        }
    }


    // Calculates the sum of all elements
    private int calculateSum(int[] values) {
        int sum = 0;

        for (int value : values) {
            sum += value;
        }

        return sum;
    }

    // Finds the minimum element in a non-empty array
    private int findMinimumValue(int[] values) {
        int min = values[0];

        for (int value : values) {
            if (value < min) {
                min = value;
            }
        }

        return min;
    }

    // Finds the maximum element in a non-empty array
    private int findMaximumValue(int[] values) {
        int max = values[0];

        for (int value : values) {
            if (value > max) {
                max = value;
            }
        }

        return max;
    }

    // Calculates the average of a non-empty array
    private double calculateAverageValue(int[] values) {
        int sum = calculateSum(values);

        return (double) sum / values.length;
    }

}