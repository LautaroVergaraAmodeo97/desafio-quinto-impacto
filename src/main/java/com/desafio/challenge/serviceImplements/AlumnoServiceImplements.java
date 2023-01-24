package com.desafio.challenge.serviceImplements;

import com.desafio.challenge.dto.AlumnoRequestDTO;
import com.desafio.challenge.dto.AlumnoResponseDTO;
import com.desafio.challenge.entidades.Alumno;
import com.desafio.challenge.exception.ErrorServicioException;
import com.desafio.challenge.mapper.AlumnoMapper;
import com.desafio.challenge.repositorio.AlumnoRepository;
import com.desafio.challenge.services.AlumnoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AlumnoServiceImplements implements AlumnoService {

@Autowired
private AlumnoRepository alumnoRepository;

@Autowired
private AlumnoMapper alumnoMapper;


private static final String ERROR_ALUMNO_NOT_FOUND = "No se encontro el alumno";

@Override
    public Alumno findById(String uuid) throws ErrorServicioException{
    return alumnoRepository.findById(uuid).orElseThrow(() -> new ErrorServicioException(ERROR_ALUMNO_NOT_FOUND));
}

    @Override
    public AlumnoResponseDTO crearUsuario(AlumnoRequestDTO alumnoDTO) {
        return alumnoMapper.toResponseDTO(alumnoRepository.save(alumnoMapper.requestToAlumno(alumnoDTO)));
    }

    @Override
    public AlumnoResponseDTO modificarUsuario(AlumnoRequestDTO alumno, String uuid) throws ErrorServicioException {

    Alumno alumno1 = alumnoRepository.findById(uuid).orElseThrow(() -> new ErrorServicioException(ERROR_ALUMNO_NOT_FOUND));

    //Validaciones

        boolean validacionNombre = alumno1.getNombre() != null && alumno.getNombre() == null;
        boolean validacionEdad= alumno1.getEdad() != 0 && alumno.getEdad() == 0;
        boolean validacionNacimiento = alumno1.getNacimiento() != null && alumno.getNacimiento()==null;
        boolean validacionHistoria = alumno1.getHistorias() != null && alumno.getHistorias()==null;
        boolean validacionCursos = alumno1.getCursos() != null && alumno.getCursos() == null;

        if(validacionNombre){
            throw new ErrorServicioException("Debe ingresar un nombre");
        }

        if(validacionEdad){
            throw new ErrorServicioException("Debe ingresar una edad");
        }

        if(validacionNacimiento){
            throw new ErrorServicioException("Debe ingresar una fecha valida");
        }

        if(validacionHistoria){
            throw new ErrorServicioException("Debe ingresar una historia valida");
        }

        if(validacionCursos){
            throw new ErrorServicioException("Debe ingresar un curso valido");
        }

    //Actualizacion de usuario
    alumno1.setNombre(alumno.getNombre());
    alumno1.setEdad(alumno.getEdad());
    alumno1.setNacimiento(alumno.getNacimiento());
    alumno1.setHistorias(alumno.getHistorias());
    alumno1.setCursos(alumno.getCursos());



    return alumnoMapper.toResponseDTO(alumnoRepository.save(alumno1));
    }

    @Override
    @Transactional
    public boolean eliminar(String uuid) throws ErrorServicioException {

        Alumno alumno = alumnoRepository.findById(uuid).orElseThrow(() -> new ErrorServicioException(ERROR_ALUMNO_NOT_FOUND));

        alumno.setDeleted(true);

        return alumnoRepository.save(alumno).isDeleted();
    }



}
