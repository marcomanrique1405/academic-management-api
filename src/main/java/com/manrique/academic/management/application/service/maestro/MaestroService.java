package com.manrique.academic.management.application.service.maestro;

import com.manrique.academic.management.application.dto.request.maestro.ActualizarMaestroRequest;
import com.manrique.academic.management.application.dto.request.maestro.ActualizarMestroParcialRequest;
import com.manrique.academic.management.application.dto.request.maestro.BuscarMaestroFiltroRequest;
import com.manrique.academic.management.application.dto.request.maestro.CrearMaestroRequest;
import com.manrique.academic.management.application.dto.response.maestro.MaestroResponse;
import com.manrique.academic.management.domain.enums.EstatusMaestro;
import com.manrique.academic.management.domain.model.Maestro;
import com.manrique.academic.management.infrastructure.repository.MaestroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MaestroService {

    private final MaestroRepository maestroRepository;

    public MaestroService(MaestroRepository maestroRepository) {
        this.maestroRepository = maestroRepository;
    }

    public List<MaestroResponse> buscarMaestroPorFiltros(BuscarMaestroFiltroRequest request) {
        List<Maestro> maestros = maestroRepository.buscarMaestros(
                request.getNumeroEmpleado(),
                request.getEstatus());

        return Optional.ofNullable(maestros)
                .orElse(List.of())
                .stream()
                .map(this::toResponse)
                .toList();

    }

    private MaestroResponse toResponse(Maestro maestro) {
        return new MaestroResponse(
                maestro.getId(),
                maestro.getNumeroEmpleado(),
                maestro.getNombreCompleto(),
                maestro.getEmail(),
                maestro.getEstatus());
    }

    public MaestroResponse buscarPorId(UUID id) {
        Optional<Maestro> optionalMaestro = maestroRepository.findById(id);

        if (optionalMaestro.isEmpty()) {
            //Falta agregar la excepcion
        }

        Maestro maestro = optionalMaestro.get();

        return toResponse(maestro);
    }

    public MaestroResponse crearMaestro(CrearMaestroRequest request) {
        if (maestroRepository.existsByNumeroEmpleado(request.getNumeroEmpleado())) {
            //Falta excepcion
        }

        if (maestroRepository.existsByEmail(request.getEmail())) {
            //Falta la excepcion
        }

        Maestro maestro = new Maestro(
                UUID.randomUUID(),
                request.getNumeroEmpleado(),
                request.getNombreCompleto(),
                request.getEmail(),
                request.getEspecialidad(),
                EstatusMaestro.ACTIVO
        );

        maestroRepository.save(maestro);

        return toResponse(maestro);
    }

    public MaestroResponse actualizarMaestroCompleto(ActualizarMaestroRequest request, UUID id) {
        Optional<Maestro> optionalMaestro = maestroRepository.findById(id);

        if (optionalMaestro.isEmpty()) {
            //falta exception
        }

        Maestro maestro = optionalMaestro.get();

        if (maestroRepository.existsByEmail(request.getEmail())) {
            //falta excepcion
        }

        maestro.setNombreCompleto(request.getNombreCompleto());
        maestro.setEmail(request.getEmail());
        maestro.setEspecialidad(request.getEspecialidad());
        maestro.setEstatus(request.getEstatus());

        maestroRepository.save(maestro);

        return toResponse(maestro);
    }

    public MaestroResponse actualizarParcial(ActualizarMestroParcialRequest request, UUID id) {
        Optional<Maestro> optionalMaestro = maestroRepository.findById(id);

        if (optionalMaestro.isEmpty()) {
            //Falta exception
        }

        Maestro maestro = optionalMaestro.get();

        if (maestro.getNumeroEmpleado() != null) {
            if (maestroRepository.existsByNumeroEmpleado(request.getNumeroEmpleado())) {
                //Falta excepcion
            }
            maestro.setNumeroEmpleado(request.getNumeroEmpleado());
        }

        if (maestro.getNombreCompleto() != null) {
            maestro.setNombreCompleto(request.getNombreCompleto());
        }

        if (maestro.getEmail() != null ) {
            if (maestroRepository.existsByEmail(request.getEmail())) {
                //Falta exception
            }
            maestro.setEmail(request.getEmail());
        }

        if (maestro.getEspecialidad() != null) {
            maestro.setEspecialidad(request.getEspecialidad());
        }

        if (maestro.getEstatus() != null) {
            maestro.setEspecialidad(request.getEspecialidad());
        }

        maestroRepository.save(maestro);

        return toResponse(maestro);
    }

    public void eliminarMaestro(UUID id) {
        Optional<Maestro> optionalMaestro = maestroRepository.findById(id);

        if (optionalMaestro.isEmpty()) {
            //Falta exception
        }

        maestroRepository.deleteById(id);
    }

    /**
     * FALTAN ESTOS:
     * POST /tutorias — crear relación tutor–alumno (enforzar RB-01).
     * PATCH /tutorias/{id}/finalizar — set fechaFin y estatus=INACTIVA.
     * GET /maestros/{id}/alumnos — alumnos actualmente tutorados.
     */


}
