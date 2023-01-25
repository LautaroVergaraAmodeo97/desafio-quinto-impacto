package com.desafio.challenge.entidades;

//import jakarta.persistence.*;

//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Table;
//import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Curso")
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
    @OneToMany
    private ArrayList<Profesor> profesor;

    @Column(name="alumno")
    @OneToMany
    private ArrayList<Alumno> alumnos;

    @NotNull
    public boolean deleted;


}
