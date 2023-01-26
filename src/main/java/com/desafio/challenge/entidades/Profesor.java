package com.desafio.challenge.entidades;

//import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Service;

//import javax.persistence.*;
import javax.persistence.*;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Profesor")
@Entity
public class Profesor {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name="id")
    private int id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="cursos")
    private ArrayList<Curso> cursos;

    @NotNull
    public boolean deleted;


}
