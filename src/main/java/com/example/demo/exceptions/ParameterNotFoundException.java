package com.example.demo.exceptions;

public class ParameterNotFoundException extends Exception {
    String message;

    public ParameterNotFoundException(String message) {
        super(message);
    }

}
