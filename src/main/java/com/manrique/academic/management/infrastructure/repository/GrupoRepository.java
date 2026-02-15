package com.manrique.academic.management.infrastructure.repository;

import com.manrique.academic.management.domain.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GrupoRepository extends JpaRepository<Grupo, UUID> {
    boolean existsByClave(String clave);
}
