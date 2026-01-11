package com.manrique.academic.management.shared.exception;

public abstract class NotFoundException extends DomainException{
    protected NotFoundException(String massage) {
        super(massage);
    }
}
