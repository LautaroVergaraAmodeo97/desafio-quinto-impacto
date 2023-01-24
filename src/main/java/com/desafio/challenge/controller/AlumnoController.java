package com.desafio.challenge.controller;


import com.desafio.challenge.dto.AlumnoRequestDTO;
import com.desafio.challenge.dto.AlumnoResponseDTO;
import com.desafio.challenge.exception.ErrorServicioException;
import com.desafio.challenge.services.AlumnoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @PostMapping
    public AlumnoResponseDTO crearUsuario (@Valid AlumnoRequestDTO alumnoRequestDTO){
        return alumnoService.crearUsuario(alumnoRequestDTO);
    }

    @PutMapping(path = "/{id}")
    public AlumnoResponseDTO modificarUsuario(@Valid AlumnoRequestDTO alumnoRequestDTO, @PathVariable("id") String uuid ) throws ErrorServicioException {
        return alumnoService.modificarUsuario(alumnoRequestDTO,uuid);
    }

    @DeleteMapping(path = "/{id}")
    public boolean eliminarAlumno(@PathVariable("id") String uuid ) throws ErrorServicioException {

        return alumnoService.eliminar(uuid);
    }






}
