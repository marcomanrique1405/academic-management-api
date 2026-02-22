package com.manrique.academic.management.shared.exception.asignacionDocente;

import com.manrique.academic.management.shared.exception.BusinessException;

public class AsignacionDocenteDuplicadaException extends BusinessException {
    public AsignacionDocenteDuplicadaException() {
        super("La asignacion docente ya existe para ese docente, materia, grupo y periodo");
    }
}
