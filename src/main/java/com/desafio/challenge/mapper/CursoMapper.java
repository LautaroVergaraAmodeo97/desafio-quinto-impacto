
package com.desafio.challenge.mapper;

import com.desafio.challenge.dto.CursoRequestDTO;
import com.desafio.challenge.dto.CursoResponseDTO;
import com.desafio.challenge.entidades.Curso;


public interface CursoMapper {

    CursoResponseDTO toResponseDTO(Curso curso);

    Curso requestToCurso(CursoRequestDTO cursoRequestDTO);

}
