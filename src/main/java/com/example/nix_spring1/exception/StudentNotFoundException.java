package com.example.nix_spring1.exception;

import lombok.Getter;

public class StudentNotFoundException extends RuntimeException {
    @Getter
    private static final String MESSAGE = "Student doesn't exist";
}
