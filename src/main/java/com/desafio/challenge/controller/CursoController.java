package com.desafio.challenge.controller;

import com.desafio.challenge.dto.CursoRequestDTO;
import com.desafio.challenge.dto.CursoResponseDTO;
import com.desafio.challenge.exception.ErrorServicioException;
import com.desafio.challenge.services.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public class CursoController {

    @Autowired
    CursoService cursoService;

    @PostMapping
    public CursoResponseDTO crearCurso(@Valid CursoRequestDTO cursoRequestDTO){

        return cursoService.crearCurso(cursoRequestDTO);
    }

    @PutMapping(path = "/{id}")
    public CursoResponseDTO modificarCurso(@Valid CursoRequestDTO cursoRequestDTO, @PathVariable("id") String uuid) throws ErrorServicioException {

        return cursoService.modificarCurso(cursoRequestDTO,uuid);
    }

    @DeleteMapping(path = "/{id}")
    public boolean eliminarCurso (@PathVariable("id") String uuid) throws ErrorServicioException{
        return cursoService.eliminar(uuid);
    }


}
