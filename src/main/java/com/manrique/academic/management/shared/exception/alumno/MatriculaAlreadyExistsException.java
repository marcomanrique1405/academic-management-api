package com.manrique.academic.management.shared.exception.alumno;


public class MatriculaAlreadyExistsException extends RuntimeException {
    public MatriculaAlreadyExistsException(String matricula) {
        super("La matricula ya existe: " + matricula);
    }
}
