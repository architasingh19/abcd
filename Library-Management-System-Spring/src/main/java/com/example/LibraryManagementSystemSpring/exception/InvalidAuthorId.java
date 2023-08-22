package com.example.LibraryManagementSystemSpring.exception;

public class InvalidAuthorId extends Exception{
    public InvalidAuthorId(String invalidAuthorId) {
        super(invalidAuthorId);
    }
}
