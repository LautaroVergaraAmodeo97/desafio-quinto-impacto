package com.desafio.challenge.mapper;

import com.desafio.challenge.dto.AlumnoRequestDTO;
import com.desafio.challenge.dto.AlumnoResponseDTO;
import com.desafio.challenge.entidades.Alumno;
import org.springframework.web.bind.annotation.Mapping;

public interface AlumnoMapper {

    AlumnoResponseDTO toResponseDTO(Alumno alumno);

    Alumno requestToAlumno (AlumnoRequestDTO alumnoRequestDTO);


}
