package com.desafio.challenge.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Curso {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name="id")
    private int id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="turno")
    private String turno;

    @Column(name="horario")
    private String horario;

    @Column(name="profesor")
    private Profesor profesor;

    @Column(name="alumno")
    private Alumno alumnos;


}
