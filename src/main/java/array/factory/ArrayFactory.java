
package array.factory;

import array.entity.IntArray;

public class ArrayFactory {

    private int nextId = 1;

    public IntArray create(int[] values) {
        IntArray array = new IntArray(nextId, values); // Factory assigns its own ID to each array.
        nextId++;
        return array;
    }
}

// ArrayFactory — responsible for creating IntArray objects.
// create() — receives an int[] and creates an IntArray.
// new IntArray(values) — creates our entity object.


