package org.example.exception;

public class SubCategoryNotFoundException extends RuntimeException {

    public SubCategoryNotFoundException(String message) {
        super(message);
    }
}
