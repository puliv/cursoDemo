// Define el paquete donde se encuentra esta clase o interfaz (repository), 
// usado para organizar el código.
package com.example.curso.repository;

// Importa la interfaz JpaRepository, que proporciona métodos 
// ya implementados para interactuar con la base de datos
// (CRUD: crear, leer, actualizar y eliminar).
import org.springframework.data.jpa.repository.JpaRepository;

// Importa la clase Alumno, que es una entidad del modelo 
// (mapeado a una tabla en la base de datos)
import com.example.curso.model.Alumno;


public interface AlumnoRepository
    extends JpaRepository<Alumno, String> {
  // Aquí puedes agregar métodos personalizados si es necesario

}
