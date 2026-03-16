package com.manrique.academic.management.application.dto.response.docente;

import com.manrique.academic.management.domain.enums.EstatusDocente;
import com.manrique.academic.management.domain.enums.EstatusMaestro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class DocenteResponse {
    private UUID id;
    private String numeroEmpleado;
    private String nombreCompleto;
    private String email;
    private EstatusDocente estatus;

}
