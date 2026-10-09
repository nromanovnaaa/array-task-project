package array.main;

import array.entity.IntArray;
import array.exception.ArrayException;
import array.factory.ArrayFactory;
import array.reader.ArrayReader;
import array.repository.ArrayRepository;
import array.warehouse.Warehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws ArrayException {

        ArrayReader reader = new ArrayReader();
        ArrayFactory factory = new ArrayFactory();
        ArrayRepository repository = ArrayRepository.getInstance();
        Warehouse warehouse = Warehouse.getInstance();

        List<String> lines = reader.readFile("data/arrays.txt");

        for (String line : lines) {
            if (reader.isValid(line)) {
                IntArray array = reader.createArray(line, factory);
                repository.add(array);
                LOGGER.info("Valid line: {}", line);
            } else {
                LOGGER.warn("Invalid line: {}", line);
            }
        }

        IntArray array = repository.findById(1);

        if (array != null) {
            LOGGER.info("Found array with id 1");
        }

        List<IntArray> arrays = repository.findBySum(6);

        LOGGER.info("Arrays with sum 6: {}", arrays.size());

        List<IntArray> maxArrays = repository.findByMax(42);

        LOGGER.info("Arrays with max 42: {}", maxArrays.size());

        List<IntArray> minArrays = repository.findByMin(1);

        LOGGER.info("Arrays with min 1: {}", minArrays.size());

        List<IntArray> averageArrays = repository.findByAverage(2.0);

        LOGGER.info("Arrays with average 2.0: {}", averageArrays.size());

        List<IntArray> sortedArrays = repository.sortById();

        LOGGER.info("Arrays sorted by ID: {}", sortedArrays.size());

        List<IntArray> sortedBySize = repository.sortBySize();

        LOGGER.info("Arrays sorted by size: {}", sortedBySize.size());

        repository.updateElement(1, 0, 10);

        LOGGER.info("New sum: {}", warehouse.getSum(1));
        LOGGER.info("New average: {}", warehouse.getAverage(1));
        LOGGER.info("New min: {}", warehouse.getMin(1));
        LOGGER.info("New max: {}", warehouse.getMax(1));
    }
}