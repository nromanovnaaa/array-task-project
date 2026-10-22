package com.kachanova.array.reader;

public class Validator {

    private static final String ARRAY_PATTERN =
            "^[0-9]+([,;\\-– ]+[0-9]+)*$";

    // Checks whether a line contains valid array data
    public boolean isValid(String line) {
        return line != null && line.trim().matches(ARRAY_PATTERN);
    }
}
