
package com.desafio.challenge.repositorio;


import com.desafio.challenge.entidades.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository <Curso,String> {
Optional<Curso> findById(int id);




}
