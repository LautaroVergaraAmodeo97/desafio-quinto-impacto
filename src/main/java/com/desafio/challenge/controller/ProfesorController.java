package com.desafio.challenge.controller;

import com.desafio.challenge.dto.ProfesorRequestDTO;
import com.desafio.challenge.dto.ProfesorResponseDTO;
import com.desafio.challenge.exception.ErrorServicioException;
import com.desafio.challenge.services.ProfesorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public class ProfesorController {

    @Autowired
    ProfesorService profesorService;

    @PostMapping
    public ProfesorResponseDTO crearProfesor(@Valid ProfesorRequestDTO profesorRequestDTO){

        return profesorService.crearProfesor(profesorRequestDTO);
    }

    @PutMapping(path = "/{id}")
    public ProfesorResponseDTO modificarProfesor(@Valid ProfesorRequestDTO profesorRequestDTO, @PathVariable("id") String uuid) throws ErrorServicioException{

        return profesorService.modificarProfesor(profesorRequestDTO,uuid);
    }

    @DeleteMapping(path="/{id}")
    public boolean eliminarProfesor(@PathVariable("id")String uuid ) throws ErrorServicioException{

        return profesorService.eliminarProfesor(uuid);
    }



}
