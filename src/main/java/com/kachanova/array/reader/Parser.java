package com.kachanova.array.reader;

public class Parser {

    // Converts a line into an integer array
    public int[] parse(String line) {
        String[] parts = line.trim().split("[,;\\-– ]+");
        int[] values = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            values[i] = Integer.parseInt(parts[i]);
        }

        return values;
    }
}
