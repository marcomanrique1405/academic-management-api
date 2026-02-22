package com.manrique.academic.management.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Materia {
    @Id
    private UUID id;

    private String clave;
    private String nombre;
    private int creditos;

    @OneToMany(mappedBy = "materia", fetch = FetchType.LAZY)
    private List<AsignacionDocente> asignaciones = new ArrayList<>();

}
