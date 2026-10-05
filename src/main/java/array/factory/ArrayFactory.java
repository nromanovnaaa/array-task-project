package array.factory;

import array.entity.IntArray;

public class ArrayFactory {

    public IntArray create(int[] values) {
        return new IntArray(values);
    }
}

// ArrayFactory — responsible for creating IntArray objects.
// create() — receives an int[] and creates an IntArray.
// new IntArray(values) — creates our entity object.


