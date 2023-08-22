package com.example.LibraryManagementSystemSpring.exception;

public class InvalidAuthorEmail extends Exception {
    public InvalidAuthorEmail(String enterTheValidMailId) {
        super(enterTheValidMailId);
    }
}
