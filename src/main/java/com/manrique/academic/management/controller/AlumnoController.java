package com.manrique.academic.management.controller;

import com.manrique.academic.management.application.dto.request.alumno.BuscarAlumnoPaginadoRequest;
import com.manrique.academic.management.application.dto.response.alumno.AlumnoResponse;
import com.manrique.academic.management.application.service.alumno.AlumnoService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {

    private final AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping
    public Page<AlumnoResponse> listarAlumnosPaginados(BuscarAlumnoPaginadoRequest request) {
        return alumnoService.listarAlumnosPaginados(request);
    }





}
