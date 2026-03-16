package com.manrique.academic.management.application.dto.response.materia;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class MateriaResponse {
    private UUID id;
    private String clave;
    private String nombre;
    private int creditos;
}
