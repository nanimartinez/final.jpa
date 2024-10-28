package com.example.demo.DTO;

import java.util.Set;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlumnoDTO {
    @Schema(description = "Unique identifier of the student", example = "1")
    private Long id;
    
    @Schema(description = "Name of the student", example = "Jane Doe")
    private String nombre;
    
    @Schema(description = "Email address of the student", example = "jane.doe@example.com")
    private String email;
    
    @Schema(description = "Phone number of the student", example = "1234567890")
    private String telefono;

    @Schema(description = "Courses the student is enrolled in", example = "[101, 102]")
    private Set<Long> cursoIds;

    public AlumnoDTO() {
    }

    public AlumnoDTO(Long id, String nombre, String email, String telefono, Set<Long> cursoIds) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.cursoIds = cursoIds;
    }

    public Set<Long> getCursoIds() {
        return cursoIds;
    }

    public void setCursoIds(Set<Long> cursoIds) {
        this.cursoIds = cursoIds;
    }
}
