package com.desafio.challenge.dto;

import com.desafio.challenge.entidades.Curso;
import lombok.Data;

import java.util.ArrayList;

@Data
public class ProfesorRequestDTO {


    private int id;

    private String nombre;

    private String apellido;

    private ArrayList<Curso> cursos;



}
