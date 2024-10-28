package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.Column;


@Entity
@Data
@Table(name = "CURSO")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_curso", nullable = false)
    private String nombreCurso;

    @Column(name = "codigo_curso", nullable = false, unique = true)
    private int codigoCurso;

    public Curso() {}

    public Curso(String nombreCurso, int codigoCurso) {
        this.nombreCurso = nombreCurso;
        this.codigoCurso = codigoCurso;
    }

    // Getters y setters ya proporcionados por @Data de Lombok
}
