package com.manrique.academic.management.shared.exception.docente;

import com.manrique.academic.management.shared.exception.NotFoundException;

import java.util.UUID;

public class DocenteNotFoundException extends NotFoundException {
    public DocenteNotFoundException(UUID id) { super("Docente no encontrado con id: " + id); }
}
