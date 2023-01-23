package com.desafio.challenge.entidades;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Alumno {

    private String nombre;

    private int edad;

    private Date nacimiento;

    private String historias;

    private ArrayList<Curso> cursos;



}
