package com.manrique.academic.management.infrastructure.repository;

import com.manrique.academic.management.domain.enums.EstatusAlumno;
import com.manrique.academic.management.domain.model.Alumno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, UUID> {

    @Query("""
    SELECT a FROM Alumno a
    WHERE (:matricula IS NULL OR a.matricula LIKE %:matricula%)
      AND (:nombre IS NULL OR a.nombre LIKE %:nombre%)
      AND (:estatus IS NULL OR a.estatus = :estatus)
    """)
    Page<Alumno> buscarAlumnos(
            @Param("matricula") String matricula,
            @Param("nombre") String nombre,
            @Param("estatus") EstatusAlumno estatus,
            Pageable pageable
    );


    boolean existsByMatricula(String matricula);

    boolean existsByEmail(String email);

}
