
package com.desafio.challenge.serviceImplements;


import com.desafio.challenge.dto.CursoResponseDTO;
import com.desafio.challenge.dto.CursoRequestDTO;
import com.desafio.challenge.entidades.Curso;
import com.desafio.challenge.exception.ErrorServicioException;
import com.desafio.challenge.mapper.CursoMapper;
import com.desafio.challenge.repositorio.CursoRepository;
import com.desafio.challenge.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceImplements implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private CursoMapper cursoMapper;


    private static final String ERROR_CURSO_NOT_FOUND = "No se encontro el curso";

    @Override
    public Curso findByID(String uuid) throws ErrorServicioException {
        return cursoRepository.findById(uuid).orElseThrow(() -> new ErrorServicioException(ERROR_CURSO_NOT_FOUND));
    }

   @Override
    public CursoResponseDTO crearCurso(CursoRequestDTO cursoRequestDTO) {


    return cursoMapper.toResponseDTO(cursoRepository.save(cursoMapper.requestToCurso(cursoRequestDTO)));

    }

    @Override
    public CursoResponseDTO modificarCurso(CursoRequestDTO cursoRequestDTO, String uuid) throws ErrorServicioException {

        Curso curso =  cursoRepository.findById(uuid).orElseThrow(() -> new ErrorServicioException(ERROR_CURSO_NOT_FOUND));

        //validaciones
        boolean validacionNombre = curso.getNombre() != null && cursoRequestDTO.getNombre() == null;
        boolean validacionTurno = curso.getTurno() != null && cursoRequestDTO.getTurno() == null;
        boolean validacionHorario = curso.getHorario() != null && cursoRequestDTO.getHorario() == null;
        boolean validacionProfesor = curso.getProfesor() != null && cursoRequestDTO.getProfesor() == null;
        boolean validacionAlumnos= curso.getAlumnos() != null && cursoRequestDTO.getAlumnos() == null;


        if(validacionNombre){
            throw new ErrorServicioException("Debe ingresar un nombre");
        }

        if(validacionTurno){
            throw new ErrorServicioException("Debe ingresar un turno");
        }

        if(validacionHorario){
            throw new ErrorServicioException("Dene ingresar un horario");
        }

        if(validacionProfesor){
            throw new ErrorServicioException("Debe ingresar un profesor");
        }

        if(validacionAlumnos){
            throw new ErrorServicioException("Debe ingresar un alumno");
        }

    //Actualizaciones

        curso.setNombre(cursoRequestDTO.getNombre());
        curso.setTurno(cursoRequestDTO.getTurno());
        curso.setHorario(curso.getHorario());
        curso.setProfesor(cursoRequestDTO.getProfesor());
        curso.setAlumnos(cursoRequestDTO.getAlumnos());

      return cursoMapper.toResponseDTO(cursoRepository.save(curso));

    }

    @Override
    public boolean eliminar(String uuid) throws ErrorServicioException {

        Curso curso = cursoRepository.findById(uuid).orElseThrow(() -> new ErrorServicioException(ERROR_CURSO_NOT_FOUND));

        curso.setDeleted(true);


        return cursoRepository.save(curso).isDeleted();
    }
}
