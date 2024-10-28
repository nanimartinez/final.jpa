package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.DTO.CursoCreateDTO;
import com.example.demo.DTO.CursoDTO;
import com.example.demo.mapper.CursoMapper;
import com.example.demo.model.Curso;
import com.example.demo.repository.CursoRepository;

@Service
public class CursoService {

    @Autowired
    private final CursoRepository cursoRepository;
    @Autowired
    private final CursoMapper cursoMapper;

    // Constructor con inyección de dependencias
    public CursoService(CursoMapper cursoMapper, CursoRepository cursoRepository) {
        this.cursoMapper = cursoMapper;
        this.cursoRepository = cursoRepository;
    }

    // Obtener todos los cursos (con opción de incluir relaciones)
    public List<CursoDTO> getAllCursos(boolean includeRelations) {
        return cursoRepository.findAll().stream()
                .map(curso -> cursoMapper.toDTOCurso(curso, includeRelations))
                .collect(Collectors.toList());
    }

    // Obtener un curso por su ID (con opción de incluir relaciones)
    public Optional<CursoDTO> getCursoById(Long id, boolean includeRelations) {
        return cursoRepository.findById(id)
                .map(curso -> cursoMapper.toDTOCurso(curso, includeRelations));
    }

    // Guardar un nuevo curso
    public CursoDTO saveCurso(CursoCreateDTO cursoCreateDTO) {
        Curso curso = cursoMapper.toEntity(cursoCreateDTO);
        Curso savedCurso = cursoRepository.save(curso);
        return cursoMapper.toDTOCurso(savedCurso, false);
    }

    // Actualizar un curso existente
    public CursoDTO updateCurso(Long id, CursoCreateDTO cursoCreateDTO) {
        return cursoRepository.findById(id)
                .map(curso -> {
                    curso.setNombre(cursoCreateDTO.getNombre());
                    curso.setDescripcion(cursoCreateDTO.getDescripcion());
                    curso.setDuracion(cursoCreateDTO.getDuracion());
                    return cursoMapper.toDTOCurso(cursoRepository.save(curso), false);
                })
                .orElse(null);
    }

    // Eliminar un curso por su ID
    public void deleteCurso(Long id) {
        if (cursoRepository.existsById(id)) {
            cursoRepository.deleteById(id);
        } else {
            System.out.println("El curso no existe");
        }
    }
}

