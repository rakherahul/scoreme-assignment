package com.scoreme.assignment;

public class ValidationResult {

    public static ValidationResult invalid(String msg) {
        return new ValidationResult();
    }

    public boolean isValid() {
        return true;
    }
}