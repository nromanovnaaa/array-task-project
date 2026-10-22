package com.kachanova.array.service;

import com.kachanova.array.entity.IntArray;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public interface ArrayService {

    OptionalInt findMin(IntArray array);

    OptionalInt findMax(IntArray array);

    OptionalInt calculateSum(IntArray array);

    OptionalDouble calculateAverage(IntArray array);

    IntArray bubbleSort(IntArray array);

    IntArray selectionSort(IntArray array);
}