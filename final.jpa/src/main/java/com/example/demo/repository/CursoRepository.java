package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    // Método para obtener un curso por su ID
    Optional<Curso> getById(Long cursoId);
    
}
