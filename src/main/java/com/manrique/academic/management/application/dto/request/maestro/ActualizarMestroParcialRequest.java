package com.manrique.academic.management.application.dto.request.maestro;

import com.manrique.academic.management.domain.enums.EstatusMaestro;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ActualizarMestroParcialRequest {

    private String numeroEmpleado;
    private String nombreCompleto;
    private String email;
    private String especialidad;
    private EstatusMaestro estatus;

}
