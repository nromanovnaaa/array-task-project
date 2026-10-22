package com.kachanova.array.warehouse;

public class ArrayStatistics {

    private final int sum;
    private final double average;
    private final int min;
    private final int max;

    // Calculates statistics for an array
    public ArrayStatistics(int[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }

        int calculatedSum = 0;
        int calculatedMin = values[0];
        int calculatedMax = values[0];

        for (int value : values) {
            calculatedSum += value;

            if (value < calculatedMin) {
                calculatedMin = value;
            }

            if (value > calculatedMax) {
                calculatedMax = value;
            }
        }

        this.sum = calculatedSum;
        this.average = (double) calculatedSum / values.length;
        this.min = calculatedMin;
        this.max = calculatedMax;
    }

    public int getSum() {
        return sum;
    }

    public double getAverage() {
        return average;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
