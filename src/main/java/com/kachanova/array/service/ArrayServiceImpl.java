package com.kachanova.array.service;

import com.kachanova.array.entity.IntArray;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public class ArrayServiceImpl implements ArrayService {

    @Override
    public OptionalInt findMin(IntArray array) {
        int[] values = array.getValues();

        if (values.length == 0) {
            return OptionalInt.empty();
        }

        int min = values[0];

        for (int value : values) {
            if (value < min) {
                min = value;
            }
        }

        return OptionalInt.of(min);
    }

    @Override
    public OptionalInt findMax(IntArray array) {
        int[] values = array.getValues();

        if (values.length == 0) {
            return OptionalInt.empty();
        }

        int max = values[0];

        for (int value : values) {
            if (value > max) {
                max = value;
            }
        }

        return OptionalInt.of(max);
    }

    @Override
    public OptionalInt calculateSum(IntArray array) {
        int[] values = array.getValues();

        if (values.length == 0) {
            return OptionalInt.empty();
        }

        int sum = 0;

        for (int value : values) {
            sum += value;
        }

        return OptionalInt.of(sum);
    }

    @Override
    public OptionalDouble calculateAverage(IntArray array) {
        int[] values = array.getValues();

        if (values.length == 0) {
            return OptionalDouble.empty();
        }

        int sum = 0;

        for (int value : values) {
            sum += value;
        }

        double average = (double) sum / values.length;

        return OptionalDouble.of(average);
    }

    @Override
    public IntArray bubbleSort(IntArray array) {
        int[] values = array.getValues();

        for (int i = 0; i < values.length - 1; i++) {
            for (int j = 0; j < values.length - i - 1; j++) {
                if (values[j] > values[j + 1]) {
                    int temporary = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temporary;
                }
            }
        }

        return new IntArray(values);
    }

    @Override
    public IntArray selectionSort(IntArray array) {
        int[] values = array.getValues();

        for (int i = 0; i < values.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < values.length; j++) {
                if (values[j] < values[minIndex]) {
                    minIndex = j;
                }
            }

            int temporary = values[i];
            values[i] = values[minIndex];
            values[minIndex] = temporary;
        }

        return new IntArray(values);
    }
}