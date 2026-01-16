package com.manrique.academic.management.application.dto.request.maestro;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CrearMaestroRequest {

    @NotBlank
    private String numeroEmpleado;

    @NotBlank
    private String nombreCompleto;

    @NotBlank
    private String email;

    @NotBlank
    private String especialidad;
}
