package com.manrique.academic.management.shared.exception.materia;

import com.manrique.academic.management.shared.exception.NotFoundException;

import java.util.UUID;

public class MateriaNotFoundException extends NotFoundException {

    public MateriaNotFoundException(UUID id) {
        super("Materia no encontrada con id: " + id);
    }

}
