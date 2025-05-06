package com.example.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curso.model.Alumno;
import com.example.curso.repository.AlumnoRepository;

@Service
public class AlumnoService {
  @Autowired
  private AlumnoRepository alumnoRepository;

  // Metodo para almacenar un alumno en la base de datos
  // Si el alumno ya existe, no se almacena y se devuelve un mensaje
  public String alumnoAlmacenar(Alumno alumno) {
    if (alumnoRepository.findById(alumno.getRut()).isPresent()) {
      return "El alumno con el rut: " + alumno.getRut()
          + "ya existe";
    }
    alumnoRepository.save(alumno);
    return "Alumno ingresado correctamente";
  }

  // Metodo para obtener todos los alumnos de la base de datos
  public List<Alumno> obtenerAlumnos() {
    return alumnoRepository.findAll();
  }
}
