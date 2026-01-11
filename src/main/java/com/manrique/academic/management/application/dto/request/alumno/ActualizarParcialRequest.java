package com.manrique.academic.management.application.dto.request.alumno;

import com.manrique.academic.management.domain.enums.EstatusAlumno;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ActualizarParcialRequest {
    private String nombre;
    private String apellidoPaterno;
    private String getApellidoMaterno;
    private String email;
    private String telefono;
    private EstatusAlumno estatus;
}
