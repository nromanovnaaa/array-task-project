package array.warehouse;

// Imports the IntArray class because we create an IntArray object for the test
import array.entity.IntArray;

// Imports the ArrayRepository class because we test
// the connection between Repository and Warehouse
import array.repository.ArrayRepository;

// Imports @Test annotation from JUnit 5
// It tells JUnit that the method is a test
import org.junit.jupiter.api.Test;

// Imports the assertEquals method
// It compares the expected value with the actual value
import static org.junit.jupiter.api.Assertions.assertEquals;


// This class contains tests for the Warehouse class
class WarehouseTest {

    // Creates the single Warehouse object using Singleton
    private final Warehouse warehouse = Warehouse.getInstance();

    // Creates the single ArrayRepository object using Singleton
    private final ArrayRepository repository = ArrayRepository.getInstance();

    // Creates an IntArray object for the test
    // ID = 100
    // Values = 1, 2, 3
    private static final IntArray TEST_ARRAY =
            new IntArray(100, new int[]{1, 2, 3});


    // @Test tells JUnit that this method is a test
    @Test
    void shouldStoreArrayStatistics() {

        // GIVEN: put statistics for array with ID 100 into Warehouse
        // Sum = 6
        // Average = 2.0
        // Minimum = 1
        // Maximum = 3
        warehouse.update(100, 6, 2.0, 1, 3);

        // WHEN: get the stored sum from Warehouse
        int sum = warehouse.getSum(100);

        // THEN: check that the stored sum is 6
        assertEquals(6, sum);

        // WHEN: get the stored average from Warehouse
        double average = warehouse.getAverage(100);

        // THEN: check that the stored average is 2.0
        assertEquals(2.0, average);

        // WHEN: get the stored minimum from Warehouse
        int min = warehouse.getMin(100);

        // THEN: check that the stored minimum is 1
        assertEquals(1, min);

        // WHEN: get the stored maximum from Warehouse
        int max = warehouse.getMax(100);

        // THEN: check that the stored maximum is 3
        assertEquals(3, max);
    }


    // Tests recalculation of statistics after an array element is changed
    @Test
    void shouldRecalculateStatisticsAfterArrayChange() {

        // GIVEN: add the test array to the Repository
        // The initial values are 1, 2, 3
        repository.add(TEST_ARRAY);

        // WHEN: change the first element from 1 to 10
        repository.updateElement(100, 0, 10);

        // THEN: the new sum must be 15
        assertEquals(15, warehouse.getSum(100));

        // THEN: the new average must be 5.0
        assertEquals(5.0, warehouse.getAverage(100));

        // THEN: the new minimum must be 2
        assertEquals(2, warehouse.getMin(100));

        // THEN: the new maximum must be 10
        assertEquals(10, warehouse.getMax(100));
    }
}