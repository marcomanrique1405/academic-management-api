package com.manrique.academic.management.shared.exception.asignacionDocente;

import com.manrique.academic.management.shared.exception.NotFoundException;

import java.util.UUID;

public class AsignacionDocenteNotFoundException extends NotFoundException {
    public AsignacionDocenteNotFoundException(UUID id) {
        super("Docente no encontrado con id: " + id);
    }
}
