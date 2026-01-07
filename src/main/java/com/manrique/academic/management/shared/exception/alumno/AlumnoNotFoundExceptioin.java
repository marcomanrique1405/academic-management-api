package com.manrique.academic.management.shared.exception.alumno;

import java.util.UUID;

public class AlumnoNotFoundExceptioin extends RuntimeException {
    public AlumnoNotFoundExceptioin(UUID id) {
        super("El alumno no encontrado con id: " + id);
    }
}
