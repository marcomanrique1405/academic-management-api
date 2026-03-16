package com.manrique.academic.management.domain.model;

import com.manrique.academic.management.domain.enums.EstadoInscripcion;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(
        name = "inscripcion",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_alumno_asignacion",
                        columnNames = {"alumno_id", "asignacion_docente_id"}
                )
        }
)
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "alumno_id", nullable = false)
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "asignacion_docente_id", nullable = false)
    private AsignacionDocente asignacionDocente;

    private EstadoInscripcion estado;

    private int calificacion;

}
