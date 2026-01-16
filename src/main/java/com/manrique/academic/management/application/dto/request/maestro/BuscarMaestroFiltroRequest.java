package com.manrique.academic.management.application.dto.request.maestro;

import com.manrique.academic.management.domain.enums.EstatusMaestro;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BuscarMaestroFiltroRequest {

    @NotBlank
    private String numeroEmpleado;

    @NotBlank
    private EstatusMaestro estatus;
}
