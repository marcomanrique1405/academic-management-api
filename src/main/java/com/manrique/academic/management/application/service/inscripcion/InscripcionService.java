package com.manrique.academic.management.application.service.inscripcion;

import com.manrique.academic.management.application.dto.request.inscripcion.InscripcionRequest;
import com.manrique.academic.management.application.dto.response.inscripcion.InscripcionResponse;
import com.manrique.academic.management.domain.enums.EstadoInscripcion;
import com.manrique.academic.management.domain.model.Alumno;
import com.manrique.academic.management.domain.model.AsignacionDocente;
import com.manrique.academic.management.domain.model.Inscripcion;
import com.manrique.academic.management.infrastructure.repository.AlumnoRepository;
import com.manrique.academic.management.infrastructure.repository.AsignacionDocenteRepository;
import com.manrique.academic.management.infrastructure.repository.InscripcionRepository;
import com.manrique.academic.management.shared.exception.alumno.AlumnoNotFoundException;
import com.manrique.academic.management.shared.exception.asignacionDocente.AsignacionDocenteNotFoundException;
import com.manrique.academic.management.shared.exception.inscripcion.InscripcionAlreadyExistException;
import com.manrique.academic.management.shared.exception.inscripcion.InscripcionNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class InscripcionService {

    private final AlumnoRepository alumnoRepository;
    private final AsignacionDocenteRepository asignacionDocenteRepository;
    private final InscripcionRepository inscripcionRepository;

    public InscripcionResponse crearInscripcion(InscripcionRequest request) {

        Alumno alumno = alumnoRepository
                .findById(request.getAlumno())
                .orElseThrow(() -> new AlumnoNotFoundException(request.getAlumno()));

        AsignacionDocente asignacionDocente = asignacionDocenteRepository
                .findById(request.getAsignacionDocente())
                .orElseThrow(() -> new AsignacionDocenteNotFoundException(request.getAsignacionDocente()));

        if (inscripcionRepository.existsByAlumnoAndAsignacionDocente(alumno, asignacionDocente)) {
            throw new InscripcionAlreadyExistException(alumno.getId(), asignacionDocente.getId());
        }

        Inscripcion inscripcion = Inscripcion.builder()
                .alumno(alumno)
                .asignacionDocente(asignacionDocente)
                .estado(EstadoInscripcion.INSCRITO)
                .calificacion(request.getCalificacion())
                .build();

        Inscripcion guardada = inscripcionRepository.save(inscripcion);

        return toResponse(guardada);

    }

    @Transactional(readOnly = true)
    public InscripcionResponse buscarPorId(UUID id) {
        Inscripcion inscripcion = inscripcionRepository
                .findById(id)
                .orElseThrow(() -> new InscripcionNotFoundException(id));

        return toResponse(inscripcion);
    }

    public void eliminarInscripcion(UUID id) {
        Inscripcion inscripcion = inscripcionRepository
                .findById(id)
                .orElseThrow(() -> new InscripcionNotFoundException(id));

        inscripcionRepository.delete(inscripcion);
    }

    public InscripcionResponse actualizarInscripcionCompleta(UUID id, InscripcionRequest request) {

        Inscripcion inscripcion = inscripcionRepository
                .findById(id)
                .orElseThrow(() -> new InscripcionNotFoundException(id));

        Alumno alumno = alumnoRepository
                .findById(request.getAlumno())
                .orElseThrow(() -> new AlumnoNotFoundException(request.getAlumno()));

        AsignacionDocente asignacionDocente = asignacionDocenteRepository
                .findById(request.getAsignacionDocente())
                .orElseThrow(() -> new AsignacionDocenteNotFoundException(request.getAsignacionDocente()));

        inscripcion.setAlumno(alumno);
        inscripcion.setAsignacionDocente(asignacionDocente);
        inscripcion.setEstado(request.getEstado());
        inscripcion.setCalificacion(request.getCalificacion());

        return toResponse(inscripcion);
    }

    public InscripcionResponse actualizarInscripcionParcial(UUID id, InscripcionRequest request) {

        Inscripcion inscripcion = inscripcionRepository
                .findById(id)
                .orElseThrow(() -> new InscripcionNotFoundException(id));

        if (request.getAlumno() != null) {
            Alumno alumno = alumnoRepository
                    .findById(request.getAlumno())
                    .orElseThrow(() -> new AlumnoNotFoundException(request.getAlumno()));

            inscripcion.setAlumno(alumno);
        }

        if (request.getAsignacionDocente() != null) {
            AsignacionDocente asignacion = asignacionDocenteRepository
                    .findById(request.getAsignacionDocente())
                    .orElseThrow(() -> new AsignacionDocenteNotFoundException(request.getAsignacionDocente()));

            inscripcion.setAsignacionDocente(asignacion);
        }

        if (request.getEstado() != null) {
            inscripcion.setEstado(request.getEstado());
        }

        inscripcion.setCalificacion(request.getCalificacion());

        return toResponse(inscripcion);
    }

    private InscripcionResponse toResponse(Inscripcion inscripcion) {
        return new InscripcionResponse(
                inscripcion.getId(),
                inscripcion.getAlumno().getId(),
                inscripcion.getAlumno().getNombre(),
                inscripcion.getAsignacionDocente().getId(),
                inscripcion.getAsignacionDocente().getDocente().getNombreCompleto(),
                inscripcion.getAsignacionDocente().getMateria().getNombre(),
                inscripcion.getEstado(),
                inscripcion.getCalificacion()
                );
    }

}
