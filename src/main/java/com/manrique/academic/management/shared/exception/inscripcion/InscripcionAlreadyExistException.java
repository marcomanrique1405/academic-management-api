package com.manrique.academic.management.shared.exception.inscripcion;

import com.manrique.academic.management.domain.model.Alumno;
import com.manrique.academic.management.domain.model.AsignacionDocente;
import com.manrique.academic.management.shared.exception.BusinessException;

import java.util.UUID;

public class InscripcionAlreadyExistException extends BusinessException {
    public InscripcionAlreadyExistException(UUID alumno, UUID asignacionDocente) {
        super("Ya existe un registro con el alumno: " + alumno +
                "\n con con la asignacion: " + asignacionDocente);
    }
}
