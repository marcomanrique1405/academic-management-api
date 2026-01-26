package com.manrique.academic.management.infrastructure.repository;

import com.manrique.academic.management.domain.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MateriaRepository extends JpaRepository<Materia, UUID> {
    boolean existsByClave(String clave);
}
