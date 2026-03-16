package com.manrique.academic.management.shared.exception.alumno;

import com.manrique.academic.management.shared.exception.BusinessException;
import com.manrique.academic.management.shared.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


public class EmailAlreadyExistsException extends BusinessException {
    public EmailAlreadyExistsException(String email) {
        super("El email ya esta registrado: " + email );
    }
}
