package com.example.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.curso.model.Alumno;

public interface AlumnoRepository
    extends JpaRepository<Alumno, String> {
  // Aquí puedes agregar métodos personalizados si es necesario

}
