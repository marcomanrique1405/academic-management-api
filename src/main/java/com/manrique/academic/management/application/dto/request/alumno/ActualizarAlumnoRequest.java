package com.manrique.academic.management.application.dto.request.alumno;

import com.manrique.academic.management.domain.enums.EstatusAlumno;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class ActualizarAlumnoRequest {
    private String nombre;
    private String apellidoPaterno;
    private String getApellidoMaterno;
    private String email;
    private String telefono;
    private EstatusAlumno estatus;
}
