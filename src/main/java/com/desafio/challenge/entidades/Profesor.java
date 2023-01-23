package com.desafio.challenge.entidades;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Profesor {

    


    private int id;

    private String nombre;

    private String apellido;

    private ArrayList<Curso> cursos;


}
