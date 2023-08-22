package com.example.LibraryManagementSystemSpring.exception;

public class InvalidBookName extends Exception{
    public InvalidBookName(String invalidBookName) {
        super(invalidBookName);
    }
}
