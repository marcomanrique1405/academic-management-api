package com.manrique.academic.management.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

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

}
