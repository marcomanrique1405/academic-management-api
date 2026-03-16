package com.manrique.academic.management.application.dto.request.inscripcion;

import com.manrique.academic.management.domain.enums.EstadoInscripcion;
import com.manrique.academic.management.domain.model.Alumno;
import com.manrique.academic.management.domain.model.AsignacionDocente;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InscripcionRequest {

    private UUID alumno;

    private UUID asignacionDocente;

    private EstadoInscripcion estado;

    @Min(0)
    @Max(100)
    private int calificacion;

}
