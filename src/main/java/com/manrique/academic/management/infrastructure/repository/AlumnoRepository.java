package com.manrique.academic.management.infrastructure.repository;

import com.manrique.academic.management.domain.enums.EstatusAlumno;
import com.manrique.academic.management.domain.model.Alumno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, UUID> {

    Page<Alumno> findByMatriculaContainingAndNombreContainingAndEstatus(
            String matricula,
            String nombre,
            EstatusAlumno estatus,
            Pageable pageable
    );

    boolean existsByMatricula(String matricula);

    boolean existsByEmail(String email);

}
