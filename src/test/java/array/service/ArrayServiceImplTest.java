package array.service;

import array.entity.IntArray;
import org.junit.jupiter.api.Test;

import java.util.OptionalDouble;
import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayServiceImplTest {

    private static final IntArray TEST_ARRAY =
            new IntArray(new int[]{5, 2, 8, 1, 4});

    private static final IntArray EMPTY_ARRAY =
            new IntArray(new int[]{});

    private final ArrayService service = new ArrayServiceImpl();

    @Test
    void shouldFindMinimum() {
        // Given
        IntArray array = TEST_ARRAY;

        // When
        OptionalInt result = service.findMin(array);

        // Then
        assertEquals(OptionalInt.of(1), result);
    }

    @Test
    void shouldFindMaximum() {
        // Given
        IntArray array = TEST_ARRAY;

        // When
        OptionalInt result = service.findMax(array);

        // Then
        assertEquals(OptionalInt.of(8), result);
    }

    @Test
    void shouldCalculateSum() {
        // Given
        IntArray array = TEST_ARRAY;

        // When
        OptionalInt result = service.calculateSum(array);

        // Then
        assertEquals(OptionalInt.of(20), result);
    }

    @Test
    void shouldCalculateAverage() {
        // Given
        IntArray array = TEST_ARRAY;

        // When
        OptionalDouble result = service.calculateAverage(array);

        // Then
        assertEquals(OptionalDouble.of(4.0), result);
    }

    @Test
    void shouldSortUsingBubbleSort() {
        // Given
        IntArray array = TEST_ARRAY;

        // When
        IntArray result = service.bubbleSort(array);

        // Then
        assertArrayEquals(
                new int[]{1, 2, 4, 5, 8},
                result.getValues()
        );
    }

    @Test
    void shouldSortUsingSelectionSort() {
        // Given
        IntArray array = TEST_ARRAY;

        // When
        IntArray result = service.selectionSort(array);

        // Then
        assertArrayEquals(
                new int[]{1, 2, 4, 5, 8},
                result.getValues()
        );
    }

    @Test
    void shouldReturnEmptyWhenFindingMinimumInEmptyArray() {
        // Given
        IntArray array = EMPTY_ARRAY;

        // When
        OptionalInt result = service.findMin(array);

        // Then
        assertEquals(OptionalInt.empty(), result);
    }

    @Test
    void shouldReturnEmptyWhenCalculatingAverageOfEmptyArray() {
        // Given
        IntArray array = EMPTY_ARRAY;

        // When
        OptionalDouble result = service.calculateAverage(array);

        // Then
        assertEquals(OptionalDouble.empty(), result);
    }
}