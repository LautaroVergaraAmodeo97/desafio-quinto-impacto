package com.desafio.challenge.mapper;

import com.desafio.challenge.dto.ProfesorRequestDTO;
import com.desafio.challenge.dto.ProfesorResponseDTO;
import com.desafio.challenge.entidades.Profesor;

public interface ProfesorMapper {

    ProfesorResponseDTO toResponseDTO(Profesor profesor);

    Profesor requestToProfesor (ProfesorRequestDTO profesorRequestDTO);

}
