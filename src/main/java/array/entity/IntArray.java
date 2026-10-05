package array.entity;

public class IntArray {

    private final int[] values;

    public IntArray(int[] values) {
        this.values = values.clone();
    }

    public int[] getValues() {
        return values.clone();
    }
}

// int[] values — stores our array of numbers.
// private — the field is available only inside this class.
// final — the field cannot be assigned another array.
// values.clone() — creates a copy of the array.
// getValues() — returns a copy of the array.