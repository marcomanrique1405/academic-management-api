package com.manrique.academic.management.application.service.grupo;

import com.manrique.academic.management.application.dto.request.grupo.GrupoRequest;
import com.manrique.academic.management.application.dto.response.grupo.GrupoResponse;
import com.manrique.academic.management.domain.model.Grupo;
import com.manrique.academic.management.infrastructure.repository.GrupoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class GrupoService {

    private final GrupoRepository grupoRepository;

    public GrupoService(GrupoRepository grupoRepository) {
        this.grupoRepository = grupoRepository;
    }

    public GrupoResponse crearGrupo(GrupoRequest request) {
        if (grupoRepository.existsByClave(request.getClave())) {

        }

        Grupo grupo = new Grupo(
                UUID.randomUUID(),
                request.getClave(),
                request.getTurno(),
                request.getSemestre(),
                request.getCapacidad()
        );

        grupoRepository.save(grupo);

        return toResponse(grupo);
    }

    private GrupoResponse toResponse(Grupo grupo) {
        return new GrupoResponse(
                grupo.getId(),
                grupo.getClave(),
                grupo.getTurno(),
                grupo.getSemestre(),
                grupo.getCapacidad()
        );
    }

    public GrupoResponse buscarGrupo(UUID id) {
        Optional<Grupo> optionalGrupo = grupoRepository.findById(id);

        if (optionalGrupo.isEmpty()) {

        }

        Grupo grupo = optionalGrupo.get();

        return toResponse(grupo);
    }

    public void eliminarGrupo(UUID id) {
        Optional<Grupo> optionalGrupo = grupoRepository.findById(id);

        if (optionalGrupo.isEmpty()) {
            //TOCA AGREGAR UNA EXCEPTION
        }

        grupoRepository.deleteById(id);
    }





}
