package com.manrique.academic.management.application.dto.response.grupo;

import com.manrique.academic.management.domain.enums.TurnoGrupo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class GrupoResponse {
    private UUID id;
    private String clave;
    private TurnoGrupo turno;
    private int semestre;
    private int capacidad;
}
