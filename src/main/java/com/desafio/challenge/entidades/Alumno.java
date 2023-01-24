package com.desafio.challenge.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;

import java.util.ArrayList;
import java.util.Date;

@Data
@Where(clause = "deleted=0")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Alumno")
public class Alumno {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name="edad")
    private int edad;

    @Column(name="nacimiento")
    private Date nacimiento;

    @Column(name="historias")
    private String historias;

    @Column(name="cursos")
    private ArrayList<Curso> cursos;

    @NotNull
    public boolean deleted;

}
