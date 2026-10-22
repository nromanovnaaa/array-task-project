
package com.kachanova.array.reader;

import com.kachanova.array.entity.IntArray;
import com.kachanova.array.exception.ArrayException;
import com.kachanova.array.factory.ArrayFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ArrayReader {

    private final Validator validator = new Validator();
    private final Parser parser = new Parser();

    // Reads all lines from a file
    public List<String> readFile(String filePath) throws ArrayException {
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException exception) {
            throw new ArrayException("Cannot read file: " + filePath, exception);
        }
    }

    // Checks whether a line is valid
    public boolean isValid(String line) {
        return validator.isValid(line);
    }

    // Creates an array from a valid line
    public IntArray createArray(String line, ArrayFactory factory) {
        int[] values = parser.parse(line);
        return factory.create(values);
    }
}
