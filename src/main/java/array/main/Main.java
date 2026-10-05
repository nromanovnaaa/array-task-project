package array.main;

import array.exception.ArrayException;
import array.factory.ArrayFactory;
import array.reader.ArrayReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws ArrayException {

        ArrayReader reader = new ArrayReader();
        ArrayFactory factory = new ArrayFactory();

        List<String> lines = reader.readFile("data/arrays.txt");

        for (String line : lines) {
            if (reader.isValid(line)) {
                reader.createArray(line, factory);
                LOGGER.info("Valid line: {}", line);
            } else {
                LOGGER.warn("Invalid line: {}", line);
            }
        }
    }
}

// Logger — sends messages to the console and log file.
// readFile() — reads all lines from arrays.txt.
// isValid() — checks each line.
// createArray() — creates an IntArray from a valid line.
// LOGGER.info() — logs a valid line.
// LOGGER.warn() — logs an invalid line.