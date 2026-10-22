
package com.kachanova.array.warehouse;

import com.kachanova.array.entity.IntArray;
import com.kachanova.array.repository.ArrayRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WarehouseTest {

    private final Warehouse warehouse = Warehouse.getInstance();
    private final ArrayRepository repository = ArrayRepository.getInstance();

    private static final IntArray TEST_ARRAY =
            new IntArray(100, new int[]{1, 2, 3});

    // Tests storing array statistics
    @Test
    void shouldStoreArrayStatistics() {
        warehouse.update(100, new int[]{1, 2, 3});

        assertEquals(6, warehouse.getSum(100));
        assertEquals(2.0, warehouse.getAverage(100));
        assertEquals(1, warehouse.getMin(100));
        assertEquals(3, warehouse.getMax(100));
    }

    // Tests recalculation after an array element changes
    @Test
    void shouldRecalculateStatisticsAfterArrayChange() {
        repository.add(TEST_ARRAY);

        repository.updateElement(100, 0, 10);

        assertEquals(15, warehouse.getSum(100));
        assertEquals(5.0, warehouse.getAverage(100));
        assertEquals(2, warehouse.getMin(100));
        assertEquals(10, warehouse.getMax(100));
    }
}
