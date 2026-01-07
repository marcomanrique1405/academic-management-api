package com.manrique.academic.management.application.dto.request;

import com.manrique.academic.management.domain.enums.EstatusAlumno;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BuscarAlumnoPaginadoRequest {
    private String matricula;
    private String nombre;
    private EstatusAlumno estatus;
    private int page = 0;
    private int size = 10;
}
