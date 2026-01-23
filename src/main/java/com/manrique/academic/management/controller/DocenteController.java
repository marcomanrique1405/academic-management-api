package com.manrique.academic.management.controller;

import com.manrique.academic.management.application.dto.request.docente.ActualizarDocenteRequest;
import com.manrique.academic.management.application.dto.request.docente.ActualizarDocenteParcialRequest;
import com.manrique.academic.management.application.dto.request.docente.BuscarDocenteFiltroRequest;
import com.manrique.academic.management.application.dto.request.docente.CrearDocenteRequest;
import com.manrique.academic.management.application.dto.response.docente.DocenteResponse;
import com.manrique.academic.management.application.service.docente.DocenteService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/docente")
public class DocenteController {

    private final DocenteService docenteService;

    public DocenteController(DocenteService docenteService) {
        this.docenteService = docenteService;
    }

    @PostMapping
    public DocenteResponse crearDocente(@Valid @RequestBody CrearDocenteRequest request) {
        return docenteService.crearDocente(request);
    }

    @PostMapping("/buscar")
    public List<DocenteResponse> buscarDocentePorFiltro(@RequestBody(required = false) BuscarDocenteFiltroRequest request) {
        return docenteService.buscarDocentePorFiltros(request);
    }

    @GetMapping("/{id}")
    public DocenteResponse buscarPorId(@PathVariable UUID id) {
        return docenteService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public DocenteResponse actualizarDocenteCompleto(
            @RequestBody ActualizarDocenteRequest request,
            @PathVariable UUID id) {
        System.out.println("ESTOY DENTRO");
        return docenteService.actualizarDocenteCompleto(request, id);
    }

    @DeleteMapping("/{id}")
    public void eliminarDocente(@PathVariable UUID id) {
        docenteService.eliminarDocente(id);
    }

    @PatchMapping("/{id}")
    public DocenteResponse actualizarParcial(
            @RequestBody ActualizarDocenteParcialRequest request,
            @PathVariable UUID id) {
        return docenteService.actualizarParcial(request, id);
    }
}
