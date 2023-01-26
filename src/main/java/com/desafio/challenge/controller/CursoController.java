
package com.desafio.challenge.controller;

import com.desafio.challenge.dto.CursoRequestDTO;
import com.desafio.challenge.dto.CursoResponseDTO;
import com.desafio.challenge.exception.ErrorServicioException;
import com.desafio.challenge.services.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping("/cursos")
    public CursoResponseDTO crearCurso(@Valid CursoRequestDTO cursoRequestDTO){
    	return 	cursoService.crearCurso(cursoRequestDTO);
    			
    }

    @PutMapping(path = "/{id}")
    public CursoResponseDTO modificarCurso(@Valid CursoRequestDTO cursoRequestDTO, @PathVariable("id") String uuid) throws ErrorServicioException {

        return cursoService.modificarCurso(cursoRequestDTO,uuid);
    }

    @DeleteMapping(path = "/{id}")
    public boolean eliminarCurso(@PathVariable("id") String uuid) throws ErrorServicioException{
        return cursoService.eliminar(uuid);
    }

 // @GetMapping("/cursos","/")
  //public String listarCursos(Model model){
  //model.addAttribute("cursos",cursoService.listarCurso());
  //	return "cursos";
  //
}
