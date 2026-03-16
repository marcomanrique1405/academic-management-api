package com.manrique.academic.management.controller;

import com.manrique.academic.management.application.dto.request.inscripcion.InscripcionRequest;
import com.manrique.academic.management.application.dto.response.inscripcion.InscripcionResponse;
import com.manrique.academic.management.application.service.inscripcion.InscripcionService;
import com.manrique.academic.management.infrastructure.repository.InscripcionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/inscripcion")
public class InscripcionController {

    private final InscripcionService inscripcionService;

    public InscripcionController(InscripcionService inscripcionService) {
        this.inscripcionService = inscripcionService;
    }


    @PostMapping
    public InscripcionResponse crearInscripcion(@RequestBody InscripcionRequest request) {
        return inscripcionService.crearInscripcion(request);
    }

    @GetMapping("/{id}")
    public InscripcionResponse buscarPorId(@PathVariable UUID id) {
        return inscripcionService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarInscripcion(@PathVariable UUID id) {
        inscripcionService.eliminarInscripcion(id);
    }

    @PutMapping("/{id}")
    public InscripcionResponse actualizarInscripcionCompleta(@PathVariable UUID id,@RequestBody InscripcionRequest request) {
        return inscripcionService.actualizarInscripcionCompleta(id, request);
    }

    @PatchMapping("/{id}")
    public InscripcionResponse actualizarInscripcionParcial(@PathVariable UUID id, @RequestBody InscripcionRequest request) {
        return inscripcionService.actualizarInscripcionParcial(id, request);
    }

}
