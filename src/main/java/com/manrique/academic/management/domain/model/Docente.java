package com.manrique.academic.management.domain.model;

import com.manrique.academic.management.domain.enums.EstatusDocente;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Docente {
    @Id
    private UUID id;
    private String numeroEmpleado;
    private String nombreCompleto;
    private String email;
    private String especialidad;
    private EstatusDocente estatus;

    @OneToMany(mappedBy = "docente", fetch = FetchType.LAZY)
    private List<AsignacionDocente> asignaciones = new ArrayList<>();

}
