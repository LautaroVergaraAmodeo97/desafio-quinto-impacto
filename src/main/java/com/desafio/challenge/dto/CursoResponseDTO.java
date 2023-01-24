package com.desafio.challenge.dto;

import com.desafio.challenge.entidades.Alumno;
import com.desafio.challenge.entidades.Profesor;
import lombok.Data;

@Data
public class CursoResponseDTO {

    private int id;

    private String nombre;

    private String turno;

    private String horario;

    private Profesor profesor;

    private Alumno alumnos;

}
