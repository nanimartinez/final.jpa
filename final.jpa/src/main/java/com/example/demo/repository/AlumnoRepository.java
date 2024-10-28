package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Alumno;
import com.example.demo.model.Curso;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

    // JPQL: Seleccionar cursos basados en nombre y código
    @Query("SELECT c FROM Curso c WHERE c.nombreCurso=:nombreCurso AND c.codigoCurso=:codigoCurso")
    List<Curso> buscarCursoPorNombre(String nombreCurso, int codigoCurso);
}
