package com.manrique.academic.management.application.dto.request.grupo;

import com.manrique.academic.management.domain.enums.TurnoGrupo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GrupoRequest {
    private String clave;
    private TurnoGrupo turno;
    private int semestre;
    private int capacidad;
}


