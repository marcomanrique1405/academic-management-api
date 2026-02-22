package com.manrique.academic.management.application.service.grupo;

import com.manrique.academic.management.application.dto.request.grupo.ActualizarTodoGrupo;
import com.manrique.academic.management.application.dto.request.grupo.GrupoRequest;
import com.manrique.academic.management.application.dto.response.grupo.GrupoResponse;
import com.manrique.academic.management.domain.model.Grupo;
import com.manrique.academic.management.infrastructure.repository.GrupoRepository;
import com.manrique.academic.management.shared.exception.grupo.ClaveGrupoAlreadyExistsException;
import com.manrique.academic.management.shared.exception.grupo.GrupoNotFoundException;
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

        Grupo grupo = Grupo.builder()
                .id(UUID.randomUUID())
                .clave(request.getClave())
                .turno(request.getTurno())
                .semestre(request.getSemestre())
                .capacidad(request.getCapacidad())
                .build();

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
            throw new GrupoNotFoundException(id);
        }

        Grupo grupo = optionalGrupo.get();

        return toResponse(grupo);
    }

    public void eliminarGrupo(UUID id) {
        Optional<Grupo> optionalGrupo = grupoRepository.findById(id);

        if (optionalGrupo.isEmpty()) {
            throw new GrupoNotFoundException(id);
        }

        grupoRepository.deleteById(id);
    }

    public GrupoResponse actualizarTodo(UUID id, ActualizarTodoGrupo request) {
        Optional<Grupo> optionalGrupo = grupoRepository.findById(id);

        if (optionalGrupo.isEmpty()) {
            throw new GrupoNotFoundException(id);
        }

        Grupo grupo = optionalGrupo.get();

        if (grupoRepository.existsByClave(request.getClave())) {
            throw new ClaveGrupoAlreadyExistsException(request.getClave());
        }

        grupo.setClave(request.getClave());
        grupo.setCapacidad(request.getCapacidad());
        grupo.setTurno(request.getTurno());
        grupo.setSemestre(request.getSemestre());

        grupoRepository.save(grupo);

        return toResponse(grupo);

    }

    public GrupoResponse actualizarParcial(UUID id, ActualizarTodoGrupo request) {
        Optional<Grupo> grupoOptional = grupoRepository.findById(id);

        if (grupoOptional.isEmpty()) {
            throw new GrupoNotFoundException(id);
        }

        Grupo grupo = grupoOptional.get();

        if (request.getClave() != null) {
            if (grupoRepository.existsByClave(request.getClave())) {
                throw new ClaveGrupoAlreadyExistsException(request.getClave());
            }
            grupo.setClave(request.getClave());
        }

        if (request.getTurno() != null) {
            grupo.setTurno(request.getTurno());
        }

        if (request.getSemestre() > 0) {
            grupo.setSemestre(request.getSemestre());
        }

        if (request.getCapacidad() > 0) {
            grupo.setCapacidad(request.getCapacidad());
        }

        grupoRepository.save(grupo);

        return toResponse(grupo);
    }





}
