package com.example.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curso.repository.CursoRepository;
import com.example.curso.model.Curso;

@Service
public class CursoService {
  @Autowired
  private CursoRepository cursoRepository;

  public String cursoAlmacenar(Curso curso) {
    if (cursoRepository.findById(curso.getSigla()).isPresent()) {
      return "El curso con la sigla: " + curso.getSigla()
          + "ya existe";
    }
    cursoRepository.save(curso);
    return "Curso ingresado correctamente";
  }

  // metodo get
  public List<Curso> obtenerTodos() {
    return cursoRepository.findAll();
  }
}
