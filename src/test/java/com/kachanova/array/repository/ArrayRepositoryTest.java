// This package contains the test class for ArrayRepository
package com.kachanova.array.repository;


// Imports the IntArray class because we create and use IntArray objects in tests
import com.kachanova.array.entity.IntArray;

// Imports @BeforeEach annotation from JUnit 5
// This annotation tells JUnit to run the marked method before every test
import org.junit.jupiter.api.BeforeEach;

// Imports @Test annotation from JUnit 5
// This annotation marks a method as a test method
import org.junit.jupiter.api.Test;

// Imports List because repository search methods return a List of IntArray objects
import java.util.List;

// Imports the assertEquals method used to compare expected and actual results
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


// This class contains tests for the ArrayRepository class
class ArrayRepositoryTest {

    // This field will store the ArrayRepository object used in the tests
    private ArrayRepository repository;


    // Creates an IntArray object with ID 1
    // The array contains the values 1, 2 and 3
    private final IntArray firstArray =
            new IntArray(1, new int[]{1, 2, 3});

    // Creates an IntArray object with ID 2
    // The array contains the values 5, 7 and 9
    private final IntArray secondArray =
            new IntArray(2, new int[]{5, 7, 9});

    // Creates an IntArray object with ID 3
    // The array contains the values 11, 2 and 42
    private final IntArray thirdArray =
            new IntArray(3, new int[]{11, 2, 42});


    // @BeforeEach tells JUnit to execute this method before every test
    @BeforeEach
    void setUp() {

        // Gets the single ArrayRepository object from the Singleton
        // The returned object is assigned to the repository field
        repository = ArrayRepository.getInstance();
    }


    // @Test tells JUnit that this method is a test
    @Test
    void shouldFindArrayById() {

        // GIVEN: add the firstArray object to the Repository
        repository.add(firstArray);

        // WHEN: search for an array with ID 1
        // The found IntArray object is stored in the result variable
        IntArray result = repository.findById(1);

        // THEN: check that the found array has ID 1
        assertEquals(1, result.getId());
    }


    // This annotation tells JUnit that the method below is a test
    @Test
    void shouldFindArrayByElement() {

        // GIVEN: add the thirdArray object to the Repository
        repository.add(thirdArray);

        // WHEN: search for arrays containing the value 42
        // The result is a List containing the found IntArray objects
        List<IntArray> result = repository.findByElement(42);

        // THEN: check that exactly one array was found
        assertEquals(1, result.size());
    }


    // This annotation tells JUnit that the method below is a test
    @Test
    void shouldFindArrayBySum() {

        // GIVEN: add the firstArray object to the Repository
        // Its values are 1 + 2 + 3 = 6
        repository.add(firstArray);

        // WHEN: search for arrays with sum equal to 6
        List<IntArray> result = repository.findBySum(6);

        // THEN: check that exactly one array was found
        assertEquals(1, result.size());
    }


    // This annotation tells JUnit that the method below is a test
    @Test
    void shouldFindArrayBySize() {

        // GIVEN: add the secondArray object to the Repository
        // The array contains 3 elements: 5, 7 and 9
        repository.add(secondArray);

        // WHEN: search for arrays containing exactly 3 elements
        List<IntArray> result = repository.findBySize(3);

        // THEN: check that the found array contains 3 elements
        assertEquals(3, result.get(0).getValues().length);
    }
    @Test
    void shouldFindArraysByMaximumGreaterThan() {
        // Given: add an array with maximum value 42
        repository.add(thirdArray);

        // When: find arrays with maximum greater than 40
        List<IntArray> result = repository.findByMaxGreaterThan(40);

        // Then: check that the array with ID 3 was found
        assertTrue(result.stream()
                .anyMatch(array -> array.getId() == 3));
    }
}