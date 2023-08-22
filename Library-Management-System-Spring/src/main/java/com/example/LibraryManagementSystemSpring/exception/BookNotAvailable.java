package com.example.LibraryManagementSystemSpring.exception;

public class BookNotAvailable extends Exception {
    public BookNotAvailable(String theBookIsNotAvailable) {
        super(theBookIsNotAvailable);
    }
}
