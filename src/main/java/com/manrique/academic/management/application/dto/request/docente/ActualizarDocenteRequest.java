package com.manrique.academic.management.application.dto.request.docente;

import com.manrique.academic.management.domain.enums.EstatusDocente;
import com.manrique.academic.management.domain.enums.EstatusMaestro;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ActualizarDocenteRequest {
    @NotBlank
    private String numeroEmpleado;

    @NotBlank
    private String nombreCompleto;

    @NotBlank
    private String email;

    @NotBlank
    private String especialidad;

    @NotBlank
    private EstatusDocente estatus;
}
