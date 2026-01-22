package com.manrique.academic.management.controller;

import com.manrique.academic.management.application.dto.request.maestro.ActualizarMaestroRequest;
import com.manrique.academic.management.application.dto.request.maestro.ActualizarMestroParcialRequest;
import com.manrique.academic.management.application.dto.request.maestro.BuscarMaestroFiltroRequest;
import com.manrique.academic.management.application.dto.request.maestro.CrearMaestroRequest;
import com.manrique.academic.management.application.dto.response.maestro.MaestroResponse;
import com.manrique.academic.management.application.service.maestro.MaestroService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/maestro")
public class MaestroController {
    private final MaestroService maestroService;

    public MaestroController(MaestroService maestroService) {
        this.maestroService = maestroService;
    }

    @PostMapping
    public MaestroResponse crearMaestro(@Valid @RequestBody CrearMaestroRequest request) {
        return maestroService.crearMaestro(request);
    }

    @PostMapping("/buscar")
    public List<MaestroResponse> buscarMaestroPorFiltro(@RequestBody(required = false) BuscarMaestroFiltroRequest request) {
        return maestroService.buscarMaestroPorFiltros(request);
    }

    @GetMapping("/{id}")
    public MaestroResponse buscarPorId(@PathVariable UUID id) {
        return maestroService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public MaestroResponse actualizarMaestroCompleto(@RequestBody ActualizarMaestroRequest request, @PathVariable UUID id) {
        System.out.println("ESTOY DENTRO");
        return maestroService.actualizarMaestroCompleto(request,id);
    }

    @DeleteMapping("/{id}")
    public void eliminarMaestro(@PathVariable UUID id) {
        maestroService.eliminarMaestro(id);
    }

    @PatchMapping("/{id}")
    public MaestroResponse actualizarParcial(@RequestBody ActualizarMestroParcialRequest request,@PathVariable UUID id) {
        return maestroService.actualizarParcial(request, id);
    }


}
