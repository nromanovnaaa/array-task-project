
package com.kachanova.array.entity;

import java.util.Arrays;

public class IntArray {

    private final int id;       // Array identifier
    private final int[] values; // Array elements

    // Creates an array with an identifier
    public IntArray(int id, int[] values) {
        this.id = id;
        this.values = values.clone();
    }

    // Creates an array with the default identifier
    public IntArray(int[] values) {
        this(0, values);
    }

    // Returns the array identifier
    public int getId() {
        return id;
    }

    // Returns a copy of the elements
    public int[] getValues() {
        return values.clone();
    }

    // Changes an element after checking the index
    public void setValue(int index, int value) {
        if (index < 0 || index >= values.length) {
            throw new IndexOutOfBoundsException("Invalid array index: " + index);
        }
        values[index] = value;
    }

    // Compares two arrays by identifier and elements
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        IntArray intArray = (IntArray) object;
        return id == intArray.id && Arrays.equals(values, intArray.values);
    }

    // Calculates the hash code
    @Override
    public int hashCode() {
        int result = Integer.hashCode(id);
        result = 31 * result + Arrays.hashCode(values);
        return result;
    }

    // Returns a readable representation of the array
    @Override
    public String toString() {
        return "IntArray{id=" + id + ", values=" + Arrays.toString(values) + "}";
    }
}
