package com.manrique.academic.management.shared.exception.alumno;

import com.manrique.academic.management.shared.exception.BusinessException;
import com.manrique.academic.management.shared.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class MatriculaAlreadyExistsException extends BusinessException {
    public MatriculaAlreadyExistsException(String matricula) {
        super("La matricula ya existe: " + matricula);
    }
}
