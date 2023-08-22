package com.example.LibraryManagementSystemSpring.exception;

public class InvalidAutherName extends Exception {
    public InvalidAutherName(String enterTheValidAuthorName) {
        super(enterTheValidAuthorName);
    }
}
