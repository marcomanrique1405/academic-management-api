package com.manrique.academic.management.domain.model;

import com.manrique.academic.management.domain.enums.EstatusAlumno;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Alumno {
    @Id
    private UUID id;

    private String matricula;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String email;
    private String telefono;
    private LocalDate fechaIngreso;
    private EstatusAlumno estatus;
}
