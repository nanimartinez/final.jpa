package com.example.demo.mapper;

import org.springframework.stereotype.Component;
import com.example.demo.DTO.AlumnoDTO;
import com.example.demo.model.Alumno;
import com.example.demo.model.Curso;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class AlumnoMapper {

    // Método para convertir de entidad Alumno a DTO Alumno
    public AlumnoDTO toDTOAlumno(Alumno alumno) {
        if (alumno == null) {
            throw new IllegalArgumentException("La entidad Alumno no puede ser nula");
        }

        Set<Long> cursoIds = alumno.getCursos().stream()
                .map(Curso::getId)
                .collect(Collectors.toSet());

        return AlumnoDTO.builder()
                .id(alumno.getId())
                .nombre(alumno.getNombre())
                .email(alumno.getEmail())
                .telefono(alumno.getTelefono())
                .cursoIds(cursoIds)
                .build();
    }

    // Método para convertir de DTO Alumno a entidad Alumno
    public Alumno toEntity(AlumnoDTO alumnoDTO) {
        if (alumnoDTO == null) {
            throw new IllegalArgumentException("El AlumnoDTO no puede ser nulo");
        }

        Alumno alumno = new Alumno();
        alumno.setId(alumnoDTO.getId());
        alumno.setNombre(alumnoDTO.getNombre());
        alumno.setEmail(alumnoDTO.getEmail());
        alumno.setTelefono(alumnoDTO.getTelefono());
        return alumno;
    }
}
