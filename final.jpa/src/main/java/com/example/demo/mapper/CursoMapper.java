package com.example.demo.mapper;

import org.springframework.stereotype.Component;
import com.example.demo.DTO.CursoCreateDTO;
import com.example.demo.DTO.CursoDTO;
import com.example.demo.model.Curso;
import java.util.stream.Collectors;

@Component
public class CursoMapper {

    private final AlumnoMapper alumnoMapper;

    public CursoMapper(AlumnoMapper alumnoMapper) {
        this.alumnoMapper = alumnoMapper;
    }

    // Método para convertir de entidad Curso a DTO Curso, con opción de incluir relaciones
    public CursoDTO toDTOCurso(Curso curso, boolean includeRelations) {
        if (curso == null) {
            throw new IllegalArgumentException("La entidad Curso no puede ser nula");
        }

        CursoDTO.CursoDTOBuilder builder = CursoDTO.builder()
                .id(curso.getId())
                .nombre(curso.getNombre())
                .descripcion(curso.getDescripcion())
                .codigo(curso.getCodigo());

        if (includeRelations) {
            // Incluir los alumnos si se solicita
            builder.alumnos(curso.getAlumnos().stream()
                    .map(alumnoMapper::toDTOAlumno)
                    .collect(Collectors.toSet()));
        }

        return builder.build();
    }

    // Método para convertir de DTO Curso a entidad Curso
    public Curso toEntity(CursoCreateDTO cursoCreateDTO) {
        if (cursoCreateDTO == null) {
            throw new IllegalArgumentException("El cursoCreateDTO no puede ser nulo");
        }

        Curso curso = new Curso();
        curso.setId(cursoCreateDTO.getId());
        curso.setNombre(cursoCreateDTO.getNombre());
        curso.setDescripcion(cursoCreateDTO.getDescripcion());
        curso.setCodigo(cursoCreateDTO.getCodigo());
        // No se asignan relaciones en la creación o actualización.
        return curso;
    }
}
