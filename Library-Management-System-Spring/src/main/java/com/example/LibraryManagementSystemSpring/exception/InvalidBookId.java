package com.example.LibraryManagementSystemSpring.exception;

public class InvalidBookId extends Exception {
    public InvalidBookId(String enterTheValidBookId) {
        super(enterTheValidBookId);
    }
}
