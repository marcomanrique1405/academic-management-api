package com.manrique.academic.management.domain.model;

import com.manrique.academic.management.domain.enums.TurnoGrupo;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Grupo {
    @Id
    private UUID id;
    private String clave;
    private TurnoGrupo turno;
    private int semestre;
    private int capacidad;
}
