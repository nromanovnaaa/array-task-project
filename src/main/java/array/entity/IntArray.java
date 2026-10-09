package array.entity;

public class IntArray {

    private final int id;
    private final int[] values;

    public IntArray(int id, int[] values) {
        this.id = id;
        this.values = values.clone();
    }

    public IntArray(int[] values) {
        this(0, values);
    }

    public int getId() {
        return id;
    }

    public int[] getValues() {
        return values.clone();
    }

    public void setValue(int index, int value) {
        values[index] = value;
    }
}