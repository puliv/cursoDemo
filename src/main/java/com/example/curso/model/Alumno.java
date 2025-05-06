package com.example.curso.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Alumno {
  @Id
  private String rut;
  private String email;
  private String nombre;
  private String apellido;
  private String contrasena;

  public Alumno() {
    this.rut = "";
    this.email = "";
    this.nombre = "";
    this.apellido = "";
    this.contrasena = "";
  }

  // Crear tabla comun de relacion Muchos a muchos
  @ManyToMany
  @JoinTable(name = "alumno_curso", joinColumns = @JoinColumn(name = "alumno_rut"), inverseJoinColumns = @JoinColumn(name = "curso_sigla"))
  private List<Curso> cursos;

  public String getRut() {
    return rut;
  }

  public void setRut(String rut) {
    this.rut = rut;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getContrasena() {
    return contrasena;
  }

  public void setContrasena(String contrasena) {
    this.contrasena = contrasena;
  }

  public List<Curso> getCursos() {
    return cursos;
  }

  public void setCursos(List<Curso> cursos) {
    this.cursos = cursos;
  }
}
