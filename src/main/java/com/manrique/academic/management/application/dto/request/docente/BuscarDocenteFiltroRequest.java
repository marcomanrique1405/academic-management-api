package com.manrique.academic.management.application.dto.request.docente;

import com.manrique.academic.management.domain.enums.EstatusMaestro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BuscarDocenteFiltroRequest {

    private String numeroEmpleado;

    private EstatusMaestro estatus;
}
