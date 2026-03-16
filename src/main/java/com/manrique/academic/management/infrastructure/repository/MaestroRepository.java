package com.manrique.academic.management.infrastructure.repository;

import com.manrique.academic.management.domain.model.Maestro;
import com.manrique.academic.management.domain.enums.EstatusMaestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface MaestroRepository extends JpaRepository<Maestro, UUID> {

    @Query("""
        SELECT m FROM Maestro m
        WHERE (:numeroEmpleado IS NULL OR m.numeroEmpleado LIKE CONCAT('%', :numeroEmpleado, '%'))
          AND (:estatus IS NULL OR m.estatus = :estatus)
    """)
    List<Maestro> buscarMaestros(
            @Param("numeroEmpleado") String numeroEmpleado,
            @Param("estatus") EstatusMaestro estatus
    );

    boolean existsByNumeroEmpleado(String numeroEmpleado);

    boolean existsByEmail(String email);
}
