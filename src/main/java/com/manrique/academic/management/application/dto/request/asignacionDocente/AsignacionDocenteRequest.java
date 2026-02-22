package com.manrique.academic.management.application.dto.request.asignacionDocente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AsignacionDocenteRequest {
    private UUID docente;
    private UUID materia;
    private UUID grupo;
    private String periodo;
}
