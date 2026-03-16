package com.manrique.academic.management.shared.exception.inscripcion;

import com.manrique.academic.management.shared.exception.DomainException;
import com.manrique.academic.management.shared.exception.NotFoundException;

import java.util.UUID;

public class InscripcionNotFoundException extends NotFoundException {
    public InscripcionNotFoundException(UUID id) {
        super("Inscripcion no encontrada con id: " + id);
    }
}
