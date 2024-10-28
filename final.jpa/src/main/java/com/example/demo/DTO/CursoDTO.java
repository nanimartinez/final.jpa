package com.example.demo.DTO;

import lombok.Builder;
import lombok.Data;
import java.util.Set;

import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Builder
public class CursoDTO {
    @Schema(description = "Id of the course", example = "1")
    private Long id;

    @Schema(description = "Name of the course", example = "Mathematics")
    private String nombre;

    @Schema(description = "Description of the course", example = "Introduction to Mathematics")
    private String descripcion;

    @Schema(description = "Duration of the course in hours", example = "40")
    private Integer duracionHoras;

    private Set<AlumnoDTO> alumnos;

    public CursoDTO() {
    }

    public CursoDTO(Long id, String nombre, String descripcion, Integer duracionHoras, Set<AlumnoDTO> alumnos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracionHoras = duracionHoras;
        this.alumnos = alumnos;
    }

    public Set<AlumnoDTO> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<AlumnoDTO> alumnos) {
        this.alumnos = alumnos;
    }
}