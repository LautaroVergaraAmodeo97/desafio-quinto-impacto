package com.desafio.challenge.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Profesor {


    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private int id;

    private String nombre;

    private String apellido;

    private ArrayList<Curso> cursos;


}
