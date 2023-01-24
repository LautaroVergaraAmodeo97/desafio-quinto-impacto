package com.desafio.challenge.services;

import com.desafio.challenge.dto.ProfesorRequestDTO;
import com.desafio.challenge.dto.ProfesorResponseDTO;
import com.desafio.challenge.entidades.Profesor;
import com.desafio.challenge.exception.ErrorServicioException;

public interface ProfesorService {

    Profesor findById() throws ErrorServicioException;

    ProfesorResponseDTO crearProfesor(ProfesorRequestDTO profesorRequestDTO);

    ProfesorResponseDTO modificarProfesor(ProfesorRequestDTO profesorRequestDTO, String uuid) throws ErrorServicioException;

    boolean eliminarProfesor(String uuid) throws ErrorServicioException;


}
