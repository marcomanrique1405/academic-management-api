package com.manrique.academic.management.shared.exception.grupo;

import com.manrique.academic.management.shared.exception.NotFoundException;

import java.util.UUID;

public class GrupoNotFoundException extends NotFoundException {
    public GrupoNotFoundException(UUID id) {
        super("Materia no encontrada con id: " + id);
    }
}
