package com.manrique.academic.management.infrastructure.repository;

import com.manrique.academic.management.domain.model.AsignacionDocente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AsignacionDocenteRepository extends JpaRepository<AsignacionDocente, UUID> {

    boolean existsByDocenteIdAndMateriaIdAndGrupoIdAndPeriodo(
            UUID docente,
            UUID materia,
            UUID grupo,
            String periodo
    );
}
