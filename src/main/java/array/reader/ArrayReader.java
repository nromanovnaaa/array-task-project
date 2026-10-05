package array.reader;

import array.entity.IntArray;
import array.exception.ArrayException;
import array.factory.ArrayFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ArrayReader {

    private static final String ARRAY_PATTERN = "^[0-9]+([,;\\-– ]+[0-9]+)*$";

    public List<String> readFile(String filePath) throws ArrayException {
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException exception) {
            throw new ArrayException("Cannot read file: " + filePath);
        }
    }

    public boolean isValid(String line) {
        return line.trim().matches(ARRAY_PATTERN);
    }

    private int[] parseLine(String line) {
        String[] parts = line.trim().split("[,;\\-– ]+");
        int[] values = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            values[i] = Integer.parseInt(parts[i]);
        }

        return values;
    }

    public IntArray createArray(String line, ArrayFactory factory) {
        int[] values = parseLine(line);
        return factory.create(values);
    }
}

// ARRAY_PATTERN — regular expression for valid array lines.
// ^ — start of the line.
// [0-9]+ — one or more digits.
// [,;\\- ]+ — allowed separators: comma, semicolon, hyphen or space.
// $ — end of the line.

// строка 22-23 trim() — removes spaces at the beginning and end.
// matches() — checks the line against our regular expression.
// true — the line is valid.
// false — the line is invalid.

// строка 27 и дальше split() — separates the line into individual numbers.
// [,;\\- ]+ — comma, semicolon, hyphen or space can be a separator.
//
// Example:
// "1; 2; 3" → ["1", "2", "3"]