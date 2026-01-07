package com.manrique.academic.management.shared.exception.alumno;

public class EmailAlreadyExistsException extends RuntimeException{
    public EmailAlreadyExistsException(String email) {
        super("El email ya esta registrado: " + email );
    }
}
