package com.example.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.curso.model.Alumno;
import com.example.curso.service.AlumnoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/alumno")
public class AlumnoController {
  @Autowired
  private AlumnoService alumnoService;

  @PostMapping()
  public String almacenar(@RequestBody Alumno alumno) {
      return alumnoService.alumnoAlmacenar(alumno)  ;
  }
  
  @GetMapping
  public List<Alumno> listarAlumos() {
    return alumnoService.obtenerAlumnos();
  }
}
