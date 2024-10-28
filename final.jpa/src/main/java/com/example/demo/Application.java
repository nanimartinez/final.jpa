package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Alumno;
import com.example.demo.model.Curso;
import com.example.demo.service.AlumnoService;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private AlumnoService alumnoService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Mostramos todos los alumnos");
        for (Alumno a : this.alumnoService.getAllAlumnos()) {
            System.out.println(a);
        }

        System.out.println("Creamos un alumno");
        this.alumnoService.creandoAlumno(new Alumno("Fer", "Perez", 12345678));

        System.out.println("Mostramos cursos por nombre y código");
        for (Curso curso : this.alumnoService.buscarCursoPorNombre("Matemáticas", 101)) {
            System.out.println(curso);
        }
    }
}