package com.manrique.academic.management.shared.exception.materia;

import com.manrique.academic.management.shared.exception.BusinessException;

public class ClaveMateriaAlreadyExistsException extends BusinessException {
    public ClaveMateriaAlreadyExistsException(String clave) {
        super("La clave ya esta registrada: " + clave);
    }
}
