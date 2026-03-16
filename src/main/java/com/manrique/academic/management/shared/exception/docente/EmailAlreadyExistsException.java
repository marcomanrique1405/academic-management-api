package com.manrique.academic.management.shared.exception.docente;

import com.manrique.academic.management.shared.exception.BusinessException;

public class EmailAlreadyExistsException extends BusinessException {
    public EmailAlreadyExistsException(String email) { super("El email ya esta registrado: " + email); }
}
