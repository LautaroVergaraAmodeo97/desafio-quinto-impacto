package com.desafio.challenge.repositorio;

import com.desafio.challenge.dto.CursoResponseDTO;
import com.desafio.challenge.entidades.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CursoRepository extends JpaRepository <Curso,String> {
Optional<Curso> findById(int id);




}
