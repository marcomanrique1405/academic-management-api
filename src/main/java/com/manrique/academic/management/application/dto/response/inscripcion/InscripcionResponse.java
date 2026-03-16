package com.manrique.academic.management.application.dto.response.inscripcion;

import com.manrique.academic.management.domain.enums.EstadoInscripcion;
import com.manrique.academic.management.domain.model.Alumno;
import com.manrique.academic.management.domain.model.AsignacionDocente;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InscripcionResponse {

    private UUID id;

    private UUID alumno;

    private String nombreAlumno;

    private UUID asignacionDocente;

    private String nombreDocente;

    private String nombreMateria;

    private EstadoInscripcion estado;

    private int calificacion;

}
