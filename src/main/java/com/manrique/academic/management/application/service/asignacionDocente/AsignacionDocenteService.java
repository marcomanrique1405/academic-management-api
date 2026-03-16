package com.manrique.academic.management.application.service.asignacionDocente;

import com.manrique.academic.management.application.dto.request.asignacionDocente.AsignacionDocenteRequest;
import com.manrique.academic.management.application.dto.response.asignacionDocente.AsignacionDocenteResponse;
import com.manrique.academic.management.domain.model.AsignacionDocente;
import com.manrique.academic.management.domain.model.Docente;
import com.manrique.academic.management.domain.model.Grupo;
import com.manrique.academic.management.domain.model.Materia;
import com.manrique.academic.management.infrastructure.repository.AsignacionDocenteRepository;
import com.manrique.academic.management.infrastructure.repository.DocenteRepository;
import com.manrique.academic.management.infrastructure.repository.GrupoRepository;
import com.manrique.academic.management.infrastructure.repository.MateriaRepository;
import com.manrique.academic.management.shared.exception.asignacionDocente.AsignacionDocenteNotFoundException;
import com.manrique.academic.management.shared.exception.asignacionDocente.AsignacionDocenteDuplicadaException;
import com.manrique.academic.management.shared.exception.docente.DocenteNotFoundException;
import com.manrique.academic.management.shared.exception.grupo.GrupoNotFoundException;
import com.manrique.academic.management.shared.exception.materia.MateriaNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class AsignacionDocenteService {

    private final AsignacionDocenteRepository asignacionDocenteRepository;
    private final DocenteRepository docenteRepository;
    private final MateriaRepository materiaRepository;
    private final GrupoRepository grupoRepository;


    public AsignacionDocenteResponse crearAsignacionDocente(AsignacionDocenteRequest request) {

        Docente docente = docenteRepository
                .findById(request.getDocente())
                .orElseThrow(() -> new DocenteNotFoundException(request.getDocente()));

        Materia materia = materiaRepository
                .findById(request.getMateria())
                .orElseThrow(() -> new MateriaNotFoundException(request.getMateria()));

        Grupo grupo = grupoRepository
                .findById(request.getGrupo())
                .orElseThrow(() -> new GrupoNotFoundException(request.getGrupo()));

        boolean yaExiste = asignacionDocenteRepository
                .existsByDocenteIdAndMateriaIdAndGrupoIdAndPeriodo(
                        docente.getId(),
                        materia.getId(),
                        grupo.getId(),
                        request.getPeriodo());

        if (yaExiste) {
            throw new AsignacionDocenteDuplicadaException();
        }

        AsignacionDocente asignacionDocente = AsignacionDocente.builder()
                .id(UUID.randomUUID())
                .docente(docente)
                .materia(materia)
                .grupo(grupo)
                .periodo(request.getPeriodo())
                .build();


        AsignacionDocente guardada = asignacionDocenteRepository.save(asignacionDocente);
        return toResponse(guardada);
    }

    @Transactional(readOnly = true)
    public AsignacionDocenteResponse buscarPorId(UUID id) {

        AsignacionDocente asignacionDocente = asignacionDocenteRepository
                .findById(id)
                .orElseThrow(() -> new AsignacionDocenteNotFoundException(id));

        return toResponse(asignacionDocente);
    }



    public void eliminarAsignacionDocente(UUID id) {
        AsignacionDocente asignacionDocente = asignacionDocenteRepository
                .findById(id)
                .orElseThrow(() -> new AsignacionDocenteNotFoundException(id));

        asignacionDocenteRepository.delete(asignacionDocente);
    }



    private AsignacionDocenteResponse toResponse(AsignacionDocente asigncion) {
        return new AsignacionDocenteResponse(
                asigncion.getId(),
                asigncion.getDocente().getId(),
                asigncion.getDocente().getNombreCompleto(),
                asigncion.getMateria().getId(),
                asigncion.getMateria().getNombre(),
                asigncion.getGrupo().getId(),
                asigncion.getGrupo().getClave(),
                asigncion.getPeriodo()
        );
    }



    public AsignacionDocenteResponse actualizarAsignacionDocente(
            UUID id,
            AsignacionDocenteRequest request
    ) {

        AsignacionDocente asignacion = asignacionDocenteRepository
                .findById(id)
                .orElseThrow(() -> new AsignacionDocenteNotFoundException(id));

        Docente docente = docenteRepository
                .findById(request.getDocente())
                .orElseThrow(() -> new DocenteNotFoundException(request.getDocente()));

        Materia materia = materiaRepository
                .findById(request.getMateria())
                .orElseThrow(() -> new MateriaNotFoundException(request.getMateria()));

        Grupo grupo = grupoRepository
                .findById(request.getGrupo())
                .orElseThrow(() -> new GrupoNotFoundException(request.getGrupo()));

        boolean yaExiste = asignacionDocenteRepository
                .existsByDocenteIdAndMateriaIdAndGrupoIdAndPeriodo(
                        docente.getId(),
                        materia.getId(),
                        grupo.getId(),
                        request.getPeriodo()
                );

        if (yaExiste && !asignacion.getId().equals(id)) {
            throw new AsignacionDocenteDuplicadaException();
        }

        asignacion.setDocente(docente);
        asignacion.setMateria(materia);
        asignacion.setGrupo(grupo);
        asignacion.setPeriodo(request.getPeriodo());

        return toResponse(asignacion);
    }

 }