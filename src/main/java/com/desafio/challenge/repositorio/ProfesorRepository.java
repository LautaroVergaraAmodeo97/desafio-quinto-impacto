package com.desafio.challenge.repositorio;

import com.desafio.challenge.entidades.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfesorRepository  extends JpaRepository <Profesor,String>{


Optional<Profesor> findById(int id);



}
