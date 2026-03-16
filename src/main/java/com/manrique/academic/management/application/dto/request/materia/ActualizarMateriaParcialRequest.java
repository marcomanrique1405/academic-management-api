package com.manrique.academic.management.application.dto.request.materia;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ActualizarMateriaParcialRequest {
    private String clave;
    private String nombre;
    private int creditos;
}
