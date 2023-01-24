package com.desafio.challenge.services;

import com.desafio.challenge.dto.CursoRequestDTO;
import com.desafio.challenge.dto.CursoResponseDTO;
import com.desafio.challenge.entidades.Curso;
import com.desafio.challenge.exception.ErrorServicioException;

public interface CursoService {

    Curso findByID(String uuid) throws ErrorServicioException;

    CursoResponseDTO crearCurso(CursoRequestDTO cursoRequestDTO);

    CursoResponseDTO modificarCurso(CursoRequestDTO cursoRequestDTO,String uuid) throws ErrorServicioException;

    boolean eliminar (String uuid) throws ErrorServicioException;


}
