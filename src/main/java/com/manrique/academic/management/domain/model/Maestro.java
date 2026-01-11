package com.manrique.academic.management.domain.model;

import com.manrique.academic.management.domain.enums.EstatusMaestro;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Maestro {
    @Id
    private UUID id;

    private String numeroEmpleado;
    private String nombreCompleto;
    private String email;
    private String especialidad;
    private EstatusMaestro estatus;
}
