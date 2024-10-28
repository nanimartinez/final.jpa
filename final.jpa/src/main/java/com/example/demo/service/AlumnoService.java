package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Alumno;
import com.example.demo.model.Curso;
import com.example.demo.repository.AlumnoRepository;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    // Obtener todos los alumnos
    public List<Alumno> getAllAlumnos() {
        return alumnoRepository.findAll();
    }

    // Buscar cursos por nombre del curso y código del curso
    public List<Curso> buscarCursoPorNombre(String nombreCurso, int codigoCurso) {
        return this.alumnoRepository.buscarCursoPorNombre(nombreCurso, codigoCurso);
    }

    // Crear un nuevo alumno
    public void creandoAlumno(Alumno alumno) {
        this.alumnoRepository.save(alumno);
    }

    // Borrar un alumno
    public void borrarAlumno(Alumno alumno) {
        if (this.alumnoRepository.existsById(alumno.getId())) {
            this.alumnoRepository.delete(alumno);
        } else {
            System.out.println("El alumno no existe");
        }
    }
}
