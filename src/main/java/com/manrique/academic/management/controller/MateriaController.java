package com.manrique.academic.management.controller;

import com.manrique.academic.management.application.dto.request.materia.ActualizarMateriaParcialRequest;
import com.manrique.academic.management.application.dto.request.materia.MateriaRequest;
import com.manrique.academic.management.application.dto.response.materia.MateriaResponse;
import com.manrique.academic.management.application.service.materia.MateriaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/materia")
public class MateriaController {
    private final MateriaService materiaService;

    public MateriaController(MateriaService materiaService) {
        this.materiaService = materiaService;
    }

    @PostMapping
    public MateriaResponse crearMateria(@RequestBody @Valid MateriaRequest request) {
        return materiaService.crearMateria(request);
    }

    @GetMapping("/{id}")
    public MateriaResponse buscarMateria(@PathVariable UUID id) {
        return materiaService.buscarMateria(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarMateria(@PathVariable UUID id) {
        materiaService.elimnarMateria(id);
    }

    @PutMapping("/{id}")
    public MateriaResponse actualizarMateria(@RequestBody @Valid MateriaRequest request, @PathVariable UUID id) {
        return materiaService.actualizarMateria(request, id);
    }

    @PatchMapping("/{id}")
    public MateriaResponse actualizarMateriaParcial(@RequestBody ActualizarMateriaParcialRequest request, @PathVariable UUID id) {
        return materiaService.actualizarMateriParcial(request, id);
    }
}
