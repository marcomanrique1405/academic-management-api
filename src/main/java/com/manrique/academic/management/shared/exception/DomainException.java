package com.manrique.academic.management.shared.exception;

public class DomainException extends RuntimeException {
    protected DomainException(String massage) {
        super(massage);
    }
}
