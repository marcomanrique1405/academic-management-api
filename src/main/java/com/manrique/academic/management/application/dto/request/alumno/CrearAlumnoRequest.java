package com.manrique.academic.management.application.dto.request.alumno;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CrearAlumnoRequest {

    @NotBlank
    @Pattern(
            regexp = "[A-Z0-9]{6,12}",
            message = "La matricula debe tener entre 6 y 12 caracteres alfanumericos en mayuscula"
    )
    private String matricula;

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellidoPaterno;

    @NotBlank
    private String apellidoMaterno;

    @Email
    @NotBlank
    private String email;

    private String telefono;

}
