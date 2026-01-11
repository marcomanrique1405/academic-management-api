package com.manrique.academic.management.application.service.alumno;

import com.manrique.academic.management.application.dto.request.alumno.ActualizarAlumnoRequest;
import com.manrique.academic.management.application.dto.request.alumno.ActualizarParcialRequest;
import com.manrique.academic.management.application.dto.request.alumno.BuscarAlumnoPaginadoRequest;
import com.manrique.academic.management.application.dto.request.alumno.CrearAlumnoRequest;
import com.manrique.academic.management.application.dto.response.alumno.AlumnoResponse;
import com.manrique.academic.management.domain.enums.EstatusAlumno;
import com.manrique.academic.management.domain.model.Alumno;
import com.manrique.academic.management.infrastructure.repository.AlumnoRepository;
import com.manrique.academic.management.shared.exception.alumno.AlumnoNotFoundException;
import com.manrique.academic.management.shared.exception.alumno.EmailAlreadyExistsException;
import com.manrique.academic.management.shared.exception.alumno.MatriculaAlreadyExistsException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Service
public class AlumnoService {
    private final AlumnoRepository alumnoRepository;

    public AlumnoService(AlumnoRepository alumnoRepository) { this.alumnoRepository = alumnoRepository; }

    public Page<AlumnoResponse> listarAlumnosPaginados(BuscarAlumnoPaginadoRequest request) {
        Pageable pageable = PageRequest.of(
                request.getPage(),
                limitarSize(request.getSize())
        );

        Page<Alumno> alumnos = alumnoRepository.buscarAlumnos(
                valor(request.getMatricula()),
                valor(request.getNombre()),
                request.getEstatus(),
                pageable
        );

        return alumnos.map(this::toResponse);
    }

    private int limitarSize(int size) {
        return Math.min(size, 50);
    }

    private String valor(String value) {
        return value == null ? "" : value;
    }

    private AlumnoResponse toResponse(Alumno alumno) {
        return new AlumnoResponse(
                alumno.getId(),
                alumno.getMatricula(),
                alumno.getNombre(),
                alumno.getApellidoPaterno(),
                alumno.getApellidoMaterno(),
                alumno.getEstatus()
        );
    }


    public AlumnoResponse buscarPorId(UUID id) {
        Optional<Alumno> optionalAlumno = alumnoRepository.findById(id);

        if (optionalAlumno.isEmpty()){
            throw new AlumnoNotFoundException(id);
        }

        Alumno alumno = optionalAlumno.get();

        return toResponse(alumno);
    }


    public AlumnoResponse crearAlumno(CrearAlumnoRequest request) {

        if (alumnoRepository.existsByMatricula(request.getMatricula())) {
            throw new MatriculaAlreadyExistsException(request.getMatricula());
        }

        if (alumnoRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException(request.getEmail());
        }

        Alumno alumno = new Alumno(
                UUID.randomUUID(),
                request.getMatricula(),
                request.getNombre(),
                request.getApellidoPaterno(),
                request.getApellidoMaterno(),
                request.getEmail(),
                request.getTelefono(),
                LocalDate.now(),
                EstatusAlumno.ACTIVO);

        System.out.println(alumno.getEmail());

        alumnoRepository.save(alumno);

        return toResponse(alumno);

    }

    public AlumnoResponse actualizarAlumnoCompleto(ActualizarAlumnoRequest request, UUID id) {
        Optional<Alumno> alumnoOptional = alumnoRepository.findById(id);

        if (alumnoOptional.isEmpty()){
            throw new AlumnoNotFoundException(id);
        }

        Alumno alumno = alumnoOptional.get();

        if (alumnoRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException(request.getEmail());
        }

        alumno.setNombre(request.getNombre());
        alumno.setApellidoPaterno(request.getApellidoPaterno());
        alumno.setApellidoMaterno(request.getApellidoMaterno());
        alumno.setEmail(request.getEmail());
        alumno.setTelefono(request.getTelefono());
        alumno.setFechaIngreso(LocalDate.now());
        alumno.setEstatus(EstatusAlumno.ACTIVO);

        alumnoRepository.save(alumno);

        return toResponse(alumno);
    }

    public AlumnoResponse actualizarParcial(ActualizarParcialRequest request, UUID id) {
        Optional<Alumno> alumnoOptional = alumnoRepository.findById(id);

        if (alumnoOptional.isEmpty()) {
            throw new AlumnoNotFoundException(id);
        }

        Alumno alumno = alumnoOptional.get();

        if (alumno.getNombre() != null) {
            alumno.setNombre(request.getNombre());
        }

        if (alumno.getApellidoPaterno() != null) {
            alumno.setApellidoPaterno(request.getApellidoPaterno());
        }

        if (alumno.getApellidoMaterno() != null) {
            alumno.setApellidoMaterno(request.getApellidoMaterno());
        }

        if (alumno.getEmail() != null) {
            if (alumnoRepository.existsByEmail(request.getEmail())) {
                throw new EmailAlreadyExistsException(request.getEmail());
            }
            alumno.setEmail(request.getEmail());
        }

        if (alumno.getEstatus() != null) {
            alumno.setEstatus(request.getEstatus());
        }

        alumnoRepository.save(alumno);

        return toResponse(alumno);
    }


    public void eliminarAlumno(UUID id) {
        Optional<Alumno> alumnoOptional = alumnoRepository.findById(id);

        if (alumnoOptional.isEmpty()) {
            throw new AlumnoNotFoundException(id);
        }

        alumnoRepository.deleteById(id);

    }

    //Solo falta agregar el del cardex


}
