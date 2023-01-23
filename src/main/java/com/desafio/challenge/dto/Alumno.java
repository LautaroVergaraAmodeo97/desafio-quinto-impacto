package com.desafio.challenge.dto;

import com.desafio.challenge.entidades.Curso;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
public class Alumno {


    private String nombre;

    private int edad;

    private Date nacimiento;

    private String historias;

    private ArrayList<Curso> cursos;


}
