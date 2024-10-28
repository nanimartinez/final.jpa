package com.example.demo.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CursoCreateDTO {
    private Long id;
    
    @Schema(description = "Name of the course", example = "Mathematics")
    private String nombre;
    
    @Schema(description = "Description of the course", example = "Basic mathematics for beginners")
    private String descripcion;
    
    @Schema(description = "Duration of the course in hours", example = "40")
    private Integer duracionHoras;

    public CursoCreateDTO() {
    }

    public CursoCreateDTO(Long id, String nombre, String descripcion, Integer duracionHoras) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracionHoras = duracionHoras;
    }
}
