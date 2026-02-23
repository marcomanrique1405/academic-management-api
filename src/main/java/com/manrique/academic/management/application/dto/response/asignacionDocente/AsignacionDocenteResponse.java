package com.manrique.academic.management.application.dto.response.asignacionDocente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class AsignacionDocenteResponse {

    private UUID id;

    private UUID docenteId;
    private String docenteNombre;

    private UUID materiaId;
    private String materiaNombre;

    private UUID grupoId;
    private String grupoClave;

    private String periodo;
}
