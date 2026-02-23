package com.manrique.academic.management.application.service.materia;

import com.manrique.academic.management.application.dto.request.materia.ActualizarMateriaParcialRequest;
import com.manrique.academic.management.application.dto.request.materia.MateriaRequest;
import com.manrique.academic.management.application.dto.response.materia.MateriaResponse;
import com.manrique.academic.management.domain.model.Materia;
import com.manrique.academic.management.infrastructure.repository.MateriaRepository;
import com.manrique.academic.management.shared.exception.materia.ClaveMateriaAlreadyExistsException;
import com.manrique.academic.management.shared.exception.materia.MateriaNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class MateriaService {

    private final MateriaRepository materiaRepository;


    public MateriaService(MateriaRepository materiaRepository) {
        this.materiaRepository = materiaRepository;
    }

    public MateriaResponse crearMateria(MateriaRequest request) {

        if (materiaRepository.existsByClave(request.getClave())) {
            throw new ClaveMateriaAlreadyExistsException(request.getClave());
        }

        Materia materia = Materia.builder()
                .id(UUID.randomUUID())
                .clave(request.getClave())
                .nombre(request.getNombre())
                .creditos(request.getCreditos())
                .build();

        materiaRepository.save(materia);

        return toResponse(materia);

    }

    private MateriaResponse toResponse(Materia materia) {
        return new MateriaResponse(
                materia.getId(),
                materia.getClave(),
                materia.getNombre(),
                materia.getCreditos()
        );
    }

    public MateriaResponse buscarMateria(UUID id) {

        Optional<Materia> materiaOptional = materiaRepository.findById(id);

        if (materiaOptional.isEmpty()) {
            throw new MateriaNotFoundException(id);
        }

        Materia materia = materiaOptional.get();

        return toResponse(materia);

    }

    public void elimnarMateria(UUID id) {
        Optional<Materia> materiaOptional = materiaRepository.findById(id);

        if (materiaOptional.isEmpty()) {
            throw new MateriaNotFoundException(id);
        }

        materiaRepository.deleteById(id);
    }

    public MateriaResponse actualizarMateria(MateriaRequest request, UUID id) {

        Optional<Materia> materiaOptional = materiaRepository.findById(id);

        if (materiaOptional.isEmpty()) {
            throw new MateriaNotFoundException(id);
        }

        Materia materia = materiaOptional.get();

        if (!materia.getClave().equals(request.getClave())
                && materiaRepository.existsByClave(request.getClave())) {
            throw new ClaveMateriaAlreadyExistsException(request.getClave());
        }

        materia.setClave(request.getClave());
        materia.setNombre(request.getNombre());
        materia.setCreditos(request.getCreditos());

        materiaRepository.save(materia);

        return toResponse(materia);
    }

    public MateriaResponse actualizarMateriParcial(ActualizarMateriaParcialRequest request, UUID id) {
        Optional<Materia> materiaOptional = materiaRepository.findById(id);

        if (materiaOptional.isEmpty()) {
            throw new MateriaNotFoundException(id);
        }

        Materia materia = materiaOptional.get();

        if (request.getClave() != null ) {
            if (!materia.getClave().equals(request.getClave())
                    && materiaRepository.existsByClave(request.getClave())) {
                throw new ClaveMateriaAlreadyExistsException(request.getClave());
            }
            materia.setCreditos(request.getCreditos());
        }

        if (request.getNombre() != null) {
            materia.setNombre(request.getNombre());
        }

        if (request.getCreditos() > 0) {
            materia.setCreditos(request.getCreditos());
        }

        materiaRepository.save(materia);

        return toResponse(materia);

    }


}
