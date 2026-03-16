package com.manrique.academic.management.controller;

import com.manrique.academic.management.application.dto.request.grupo.ActualizarTodoGrupo;
import com.manrique.academic.management.application.dto.request.grupo.GrupoRequest;
import com.manrique.academic.management.application.dto.response.grupo.GrupoResponse;
import com.manrique.academic.management.application.service.grupo.GrupoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/grupos")
public class GrupoController {

    private final GrupoService grupoService;

    public GrupoController(GrupoService grupoService) {
        this.grupoService = grupoService;
    }

    @PostMapping
    public GrupoResponse crearGrupo(@RequestBody GrupoRequest request) {
        return grupoService.crearGrupo(request);
    }

    @GetMapping("/{id}")
    public GrupoResponse buscarGrupo(@PathVariable UUID id) {
        return grupoService.buscarGrupo(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminaGrupoId( @PathVariable UUID id) {
        grupoService.eliminarGrupo(id);
    }

    @PutMapping("/{id}")
    public GrupoResponse actualizarTodo(@PathVariable UUID id, @RequestBody ActualizarTodoGrupo request) {
        return grupoService.actualizarTodo(id, request);
    }

    @PatchMapping("/{id}")
    public GrupoResponse ActualizarGrupoParcial(@PathVariable UUID id, @RequestBody ActualizarTodoGrupo request) {
        return grupoService.actualizarParcial(id, request);
    }


}
