package com.manrique.academic.management.shared.exception;

public abstract class BusinessException extends DomainException {
    protected BusinessException(String massage) {
        super(massage);
    }
}
