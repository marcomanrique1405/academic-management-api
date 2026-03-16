package com.manrique.academic.management.controller;

import com.manrique.academic.management.application.dto.request.asignacionDocente.AsignacionDocenteRequest;
import com.manrique.academic.management.application.dto.response.asignacionDocente.AsignacionDocenteResponse;
import com.manrique.academic.management.application.service.asignacionDocente.AsignacionDocenteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/asignacionDocente")
public class AsignacionDocenteController {

    private final AsignacionDocenteService asignacionDocenteService;

    public AsignacionDocenteController(AsignacionDocenteService asignacionDocenteService) {
        this.asignacionDocenteService = asignacionDocenteService;
    }

    @PostMapping
    public AsignacionDocenteResponse crearAsignacionDocente(@RequestBody AsignacionDocenteRequest request) {
        return asignacionDocenteService.crearAsignacionDocente(request);
    }

    @GetMapping("/{id}")
    public AsignacionDocenteResponse buscarPorId(@PathVariable UUID id) {
        return asignacionDocenteService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarAsignacion(@PathVariable UUID id) {
        asignacionDocenteService.eliminarAsignacionDocente(id);
    }

    @PutMapping("/{id}")
    public AsignacionDocenteResponse actualizarAsignacionCompleta(@PathVariable UUID id, @RequestBody AsignacionDocenteRequest request) {
        return asignacionDocenteService.actualizarAsignacionDocente(id, request);
    }


}
