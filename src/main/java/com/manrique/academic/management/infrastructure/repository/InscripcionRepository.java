package com.manrique.academic.management.infrastructure.repository;

import com.manrique.academic.management.domain.model.Alumno;
import com.manrique.academic.management.domain.model.AsignacionDocente;
import com.manrique.academic.management.domain.model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InscripcionRepository extends JpaRepository<Inscripcion, UUID> {
    boolean existsByAlumnoAndAsignacionDocente(
            Alumno alumno ,
            AsignacionDocente asignacionDocente
            );
}
