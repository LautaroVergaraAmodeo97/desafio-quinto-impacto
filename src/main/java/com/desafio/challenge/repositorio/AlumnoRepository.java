package com.desafio.challenge.repositorio;

import com.desafio.challenge.entidades.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlumnoRepository extends JpaRepository<Alumno,String> {

Optional<Alumno> findById(int id);



}
