package com.manrique.academic.management.infrastructure.repository;

import com.manrique.academic.management.domain.enums.EstatusMaestro;
import com.manrique.academic.management.domain.model.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface DocenteRepository extends JpaRepository<Docente, UUID> {

    @Query("""
    SELECT d FROM Docente d
    WHERE (:numeroEmpleado IS NULL OR d.numeroEmpleado LIKE CONCAT('%', :numeroEmpleado, '%'))
      AND (:estatus IS NULL OR d.estatus = :estatus)
    """)
    List<Docente> buscarDocente(
            @Param("numeroEmpleado") String numeroEmpleado,
            @Param("estatus") EstatusMaestro estatus
    );

    boolean existsByNumeroEmpleado(String numeroEmpleado);

    boolean existsByEmail(String email);
}
