package com.example.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curso.model.Alumno;
import com.example.curso.model.Curso;
import com.example.curso.repository.AlumnoRepository;
import com.example.curso.repository.CursoRepository;

@Service
public class AlumnoService {
  @Autowired
  private AlumnoRepository alumnoRep;
  @Autowired // se usa uno por dependencia
  private CursoRepository cursoRep;

  // Metodo para almacenar un alumno en la base de datos
  // Si el alumno ya existe, no se almacena y se devuelve un mensaje
  public String alumnoAlmacenar(Alumno alumno) {
    if (alumnoRep.findById(alumno.getRut()).isPresent()) {
      return "El alumno con el rut: " + alumno.getRut()
          + " ya existe";
    }
    alumnoRep.save(alumno);
    return "Alumno ingresado correctamente";
  }

  // Metodo para obtener todos los alumnos de la base de datos
  public List<Alumno> obtenerAlumnos() {
    return alumnoRep.findAll();
  }

  // Metodo que asigna un alumno a un curso
  public String alumnoAsignarCurso(String rut, String sigla) {
    // Una buena practica es tratar de no tener tantos return en el codigo
    String msj = "";
    // Validamos la existencia del alomno y del curso
    if (!alumnoRep.existsById(rut)) {
      msj = "El alumno no existe";
    }

    if (!cursoRep.existsById(sigla)) {
      msj = "El curso no existe";
    }

    Curso curso = cursoRep.findById(sigla).get();
    Alumno alumno = alumnoRep.findById(rut).get();

    if (alumno.getCursos().contains(curso)) {
      msj = "El Alumno ya se encuentra inscrito";
    } else {
      alumno.getCursos().add(curso);
      alumnoRep.save(alumno);

      msj = "Alumno asignado al curso correctamente";
    }

    return msj;
  }
}
