package com.manrique.academic.management.shared.exception.docente;

import com.manrique.academic.management.shared.exception.BusinessException;

public class NumeroEmpleadoAlreadyExistsException extends BusinessException {
    public NumeroEmpleadoAlreadyExistsException(String numeroEmpleado) { super("El numero de empleado ya existe: " + numeroEmpleado); }
}
