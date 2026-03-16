package com.manrique.academic.management.application.dto.response.maestro;

import com.manrique.academic.management.domain.enums.EstatusMaestro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class MaestroResponse {
    private UUID id;
    private String numeroEmpleado;
    private String nombreCompleto;
    private String email;
    private EstatusMaestro estatus;
}
