package com.manrique.academic.management.shared.exception.alumno;

import com.manrique.academic.management.shared.exception.NotFoundException;

import java.util.UUID;

public class AlumnoNotFoundException extends NotFoundException {
    public AlumnoNotFoundException(UUID id) {
        super("El alumno no encontrado con id: " + id);
    }
}
