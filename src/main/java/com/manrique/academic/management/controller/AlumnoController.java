package com.manrique.academic.management.controller;

import com.manrique.academic.management.application.dto.request.alumno.ActualizarAlumnoRequest;
import com.manrique.academic.management.application.dto.request.alumno.ActualizarParcialRequest;
import com.manrique.academic.management.application.dto.request.alumno.BuscarAlumnoPaginadoRequest;
import com.manrique.academic.management.application.dto.request.alumno.CrearAlumnoRequest;
import com.manrique.academic.management.application.dto.response.alumno.AlumnoResponse;
import com.manrique.academic.management.application.service.alumno.AlumnoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/alumno")
public class AlumnoController {

    private final AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @PostMapping("/buscar")
    public Page<AlumnoResponse> listarAlumnosPaginados(@RequestBody BuscarAlumnoPaginadoRequest request) {
        return alumnoService.listarAlumnosPaginados(request);
    }

    @GetMapping("/{id}")
    public AlumnoResponse buscarPorId(@PathVariable UUID id) {
        return alumnoService.buscarPorId(id);
    }

    @PostMapping
    public AlumnoResponse crearAlumno(@Valid @RequestBody CrearAlumnoRequest request) {
        return alumnoService.crearAlumno(request);
    }

    @PutMapping("{id}")
    public AlumnoResponse actualizarAlumnoCompleto(@Valid @RequestBody ActualizarAlumnoRequest request, @PathVariable UUID id) {
        return alumnoService.actualizarAlumnoCompleto(request, id);
    }


    public AlumnoResponse actualizarAlumnoParcial(@RequestBody ActualizarParcialRequest request, @PathVariable UUID id) {
        return alumnoService.actualizarParcial(request, id);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void elimnarAlumnoId(@PathVariable UUID id) {
        alumnoService.eliminarAlumno(id);
    }


}
