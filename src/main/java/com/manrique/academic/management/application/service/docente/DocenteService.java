package com.manrique.academic.management.application.service.docente;

import com.manrique.academic.management.application.dto.request.docente.BuscarDocenteFiltroRequest;
import com.manrique.academic.management.application.dto.request.docente.ActualizarDocenteRequest;
import com.manrique.academic.management.application.dto.request.docente.ActualizarDocenteParcialRequest;
import com.manrique.academic.management.application.dto.request.docente.CrearDocenteRequest;
import com.manrique.academic.management.application.dto.response.docente.DocenteResponse;
import com.manrique.academic.management.domain.enums.EstatusDocente;
import com.manrique.academic.management.domain.model.Docente;
import com.manrique.academic.management.infrastructure.repository.DocenteRepository;
import com.manrique.academic.management.shared.exception.maestro.EmailAlreadyExistsException;
import com.manrique.academic.management.shared.exception.maestro.MaestroNotFoundException;
import com.manrique.academic.management.shared.exception.maestro.NumeroEmpleadoAlreadyExistsException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DocenteService {

    private final DocenteRepository docenteRepository;

    public DocenteService(DocenteRepository docenteRepository) {
        this.docenteRepository = docenteRepository;
    }

    public List<DocenteResponse> buscarDocentePorFiltros(BuscarDocenteFiltroRequest request) {

        if (request == null) {
            request = new BuscarDocenteFiltroRequest(null, null);
        }

        List<Docente> docentes = docenteRepository.buscarDocente(
                request.getNumeroEmpleado(),
                request.getEstatus()
        );

        return docentes.stream()
                .map(this::toResponse)
                .toList();
    }

    private DocenteResponse toResponse(Docente docente) {
        return new DocenteResponse(
                docente.getId(),
                docente.getNumeroEmpleado(),
                docente.getNombreCompleto(),
                docente.getEmail(),
                docente.getEstatus()
        );
    }

    public DocenteResponse buscarPorId(UUID id) {
        Optional<Docente> optionalDocente = docenteRepository.findById(id);

        if (optionalDocente.isEmpty()) {
            throw new MaestroNotFoundException(id);
        }

        Docente docente = optionalDocente.get();

        return toResponse(docente);
    }

    public DocenteResponse crearDocente(CrearDocenteRequest request) {

        if (docenteRepository.existsByNumeroEmpleado(request.getNumeroEmpleado())) {
            throw new NumeroEmpleadoAlreadyExistsException(request.getNumeroEmpleado());
        }

        if (docenteRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException(request.getEmail());
        }

        Docente docente = new Docente(
                UUID.randomUUID(),
                request.getNumeroEmpleado(),
                request.getNombreCompleto(),
                request.getEmail(),
                request.getEspecialidad(),
                EstatusDocente.ACTIVO
        );

        docenteRepository.save(docente);

        return toResponse(docente);
    }

    public DocenteResponse actualizarDocenteCompleto(ActualizarDocenteRequest request, UUID id) {
        Optional<Docente> optionalDocente = docenteRepository.findById(id);

        if (optionalDocente.isEmpty()) {
            throw new MaestroNotFoundException(id);
        }

        Docente docente = optionalDocente.get();

        if (!docente.getNumeroEmpleado().equals(request.getNumeroEmpleado())
                && docenteRepository.existsByNumeroEmpleado(request.getNumeroEmpleado())) {
            throw new NumeroEmpleadoAlreadyExistsException(request.getNumeroEmpleado());
        }

        if (docenteRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException(request.getEmail());
        }

        docente.setNombreCompleto(request.getNombreCompleto());
        docente.setEmail(request.getEmail());
        docente.setEspecialidad(request.getEspecialidad());
        docente.setEstatus(request.getEstatus());

        docenteRepository.save(docente);

        return toResponse(docente);
    }

    public DocenteResponse actualizarParcial(ActualizarDocenteParcialRequest request, UUID id) {
        Optional<Docente> optionalDocente = docenteRepository.findById(id);

        if (optionalDocente.isEmpty()) {
            throw new MaestroNotFoundException(id);
        }

        Docente docente = optionalDocente.get();

        if (docente.getNumeroEmpleado() != null) {
            if (docenteRepository.existsByNumeroEmpleado(request.getNumeroEmpleado())) {
                throw new NumeroEmpleadoAlreadyExistsException(request.getNumeroEmpleado());
            }
            docente.setNumeroEmpleado(request.getNumeroEmpleado());
        }

        if (docente.getNombreCompleto() != null) {
            docente.setNombreCompleto(request.getNombreCompleto());
        }

        if (docente.getEmail() != null) {
            if (docenteRepository.existsByEmail(request.getEmail())) {
                throw new EmailAlreadyExistsException(request.getEmail());
            }
            docente.setEmail(request.getEmail());
        }

        if (docente.getEspecialidad() != null) {
            docente.setEspecialidad(request.getEspecialidad());
        }

        if (docente.getEstatus() != null) {
            docente.setEspecialidad(request.getEspecialidad());
        }

        docenteRepository.save(docente);

        return toResponse(docente);
    }

    public void eliminarDocente(UUID id) {
        Optional<Docente> optionalDocente = docenteRepository.findById(id);

        if (optionalDocente.isEmpty()) {
            throw new MaestroNotFoundException(id);
        }

        docenteRepository.deleteById(id);
    }
}
