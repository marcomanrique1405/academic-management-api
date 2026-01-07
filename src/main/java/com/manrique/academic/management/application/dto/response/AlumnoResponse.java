package com.manrique.academic.management.application.dto.response;

import com.manrique.academic.management.domain.enums.EstatusAlumno;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class AlumnoResponse {
    private UUID id;
    private String matricula;
    private String nombre;
    private EstatusAlumno estatus;
}
