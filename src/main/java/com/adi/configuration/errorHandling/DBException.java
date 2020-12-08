package com.adi.configuration.errorHandling;

public class DBException extends RuntimeException {
    public DBException(String message) {
        super(message);
    }
}
