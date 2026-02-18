package com.manrique.academic.management.shared.exception.grupo;

import com.manrique.academic.management.shared.exception.BusinessException;

public class ClaveGrupoAlreadyExistsException extends BusinessException {
    public ClaveGrupoAlreadyExistsException(String clave) {
        super("La clave ya esta registrada" + clave);
    }
}
