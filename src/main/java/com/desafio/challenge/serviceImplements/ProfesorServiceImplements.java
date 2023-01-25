package com.desafio.challenge.serviceImplements;

import com.desafio.challenge.dto.ProfesorRequestDTO;
import com.desafio.challenge.dto.ProfesorResponseDTO;
import com.desafio.challenge.entidades.Profesor;
import com.desafio.challenge.exception.ErrorServicioException;
import com.desafio.challenge.mapper.ProfesorMapper;
import com.desafio.challenge.repositorio.ProfesorRepository;
import com.desafio.challenge.services.ProfesorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorServiceImplements implements ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private ProfesorMapper profesorMapper;

    private static final String ERROR_PROFESOR_NOT_FOUND = "No se encontro el profesor";

    @Override
    public Profesor findById(String uuid) throws ErrorServicioException {
        return profesorRepository.findById(uuid).orElseThrow(() -> new ErrorServicioException(ERROR_PROFESOR_NOT_FOUND));
    }

    @Override
    public ProfesorResponseDTO crearProfesor(ProfesorRequestDTO profesorRequestDTO) {

        return profesorMapper.toResponseDTO(profesorRepository.save(profesorMapper.requestToProfesor(profesorRequestDTO)));
    }

    @Override
    public ProfesorResponseDTO modificarProfesor(ProfesorRequestDTO profesorRequestDTO, String uuid) throws ErrorServicioException {

        Profesor profesor = profesorRepository.findById(uuid).orElseThrow(() -> new ErrorServicioException(ERROR_PROFESOR_NOT_FOUND));

        //validaciones

        boolean validacionNombre= profesor.getNombre() != null && profesorRequestDTO.getNombre() == null;
        boolean validacionApellido= profesor.getApellido() != null && profesorRequestDTO.getApellido() == null;
        boolean validacionCursos= profesor.getCursos() != null && profesorRequestDTO.getCursos() == null;

        if(validacionNombre){
            throw new ErrorServicioException("Debe ingresar un nombre");
        }

        if(validacionApellido){
            throw new ErrorServicioException("Debe ingresar un apellido");
        }

        if(validacionCursos){
            throw new ErrorServicioException("Debe ingresar un curso");
        }

        profesor.setNombre(profesor.getNombre());
        profesor.setApellido(profesor.getApellido());
        profesor.setCursos(profesor.getCursos());

        return profesorMapper.toResponseDTO(profesorRepository.save(profesor));
    }

    @Override
    @Transactional
    public boolean eliminarProfesor(String uuid) throws ErrorServicioException {

        Profesor profesor = profesorRepository.findById(uuid).orElseThrow(() -> new ErrorServicioException(ERROR_PROFESOR_NOT_FOUND));

        profesor.setDeleted(true);

        return profesorRepository.save(profesor).isDeleted();
    }
}
