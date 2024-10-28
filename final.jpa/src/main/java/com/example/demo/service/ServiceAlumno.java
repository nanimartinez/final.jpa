package com.example.demo.service;

import java.util.List;
import com.example.demo.dto.AlumnoDTO;

public interface ServiceAlumno {
    
    // Obtener un alumno por su ID
    AlumnoDTO getAlumnoById(Long id);

    // Obtener todos los alumnos
    List<AlumnoDTO> getAllAlumnos();

    // Guardar un nuevo alumno a partir del DTO
    AlumnoDTO saveAlumnoDTO(AlumnoDTO alumnoDTO);

    // Guardar un alumno desde una API externa (si aplica)
    AlumnoDTO saveAlumnoFromApi(AlumnoDTO alumnoDTO);

    // Eliminar un alumno por su ID
    void deleteAlumno(Long id);
}
