package com.desafio.challenge.entidades;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Curso {

    private String nombre;

    private String turno;

    private String horario;

    private Profesor profesor;

    private Alumno alumnos;


}
