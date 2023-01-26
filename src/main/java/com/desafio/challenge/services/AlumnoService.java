
package com.desafio.challenge.services;

import com.desafio.challenge.dto.AlumnoResponseDTO;
import com.desafio.challenge.dto.AlumnoRequestDTO;

import com.desafio.challenge.entidades.Alumno;
import com.desafio.challenge.exception.ErrorServicioException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface AlumnoService {

Alumno findById(String uuid) throws ErrorServicioException;
AlumnoResponseDTO crearUsuario (AlumnoRequestDTO alumnoRequestDTO);
AlumnoResponseDTO modificarUsuario (AlumnoRequestDTO alumnoRequestDTO,String uuid) throws ErrorServicioException;
boolean eliminar(String uuid) throws ErrorServicioException;

public List<Alumno> listarAlumnos();

}
