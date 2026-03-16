package com.manrique.academic.management.shared.exception.maestro;

import com.manrique.academic.management.shared.exception.NotFoundException;

import java.util.UUID;

public class MaestroNotFoundException extends NotFoundException {
    public MaestroNotFoundException(UUID id) { super("El maestro no encontrado con id: " + id); }
}
