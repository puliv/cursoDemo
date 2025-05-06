package com.example.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.curso.model.Curso;
import com.example.curso.service.CursoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/cursos")
public class CursoController {
  @Autowired
  private CursoService cursoService;

  @PostMapping
  public String almacenar(@RequestBody Curso curso) {
    return cursoService.cursoAlmacenar(curso);
  }

  @GetMapping
  public List<Curso> listar() {
    return cursoService.obtenerTodos();
  }

}
