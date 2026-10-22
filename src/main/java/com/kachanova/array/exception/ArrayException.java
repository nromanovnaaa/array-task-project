
package com.kachanova.array.exception;

public class ArrayException extends Exception {

    //Добавить еще 2 конструктора
    // Creates an exception without a message
    public ArrayException() {
        super();
    }

    // Creates an exception with a message
    public ArrayException(String message) {
        super(message);
    }

    // Creates an exception with a message and a cause
    public ArrayException(String message, Throwable cause) {
        super(message, cause);
    }
}
