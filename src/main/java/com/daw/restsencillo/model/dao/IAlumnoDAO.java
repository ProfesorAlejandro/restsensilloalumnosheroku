package com.daw.restsencillo.model.dao;

import com.daw.restsencillo.model.entity.Alumno;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlumnoDAO extends JpaRepository<Alumno,Long> {
	
	// Alumnos suspensos
	@Query(value = "SELECT * FROM alumnos WHERE nota < 5", nativeQuery = true)
	List<Alumno> alumnosSupensos();
	
	// Alumnos aprobados
	@Query(value = "SELECT * FROM alumnos WHERE nota >= 5", nativeQuery = true)
	List<Alumno> alumnosAprobados();
	
	// Alumnos notable
	@Query(value = "SELECT * FROM alumnos WHERE nota >= 7 AND nota < 9", nativeQuery = true)
	List<Alumno> alumnosNotable();
	
	// Alumnos sobresaliente
	@Query(value = "SELECT * FROM alumnos WHERE nota >= 9", nativeQuery = true)
	List<Alumno> alumnosSobresaliente();
	
	// Alumnos por nombre
	@Query(value = "SELECT * FROM alumnos WHERE nombre LIKE ?1%", nativeQuery = true)
	List<Alumno> alumnosPorNombre(String nombre);
	
	// Alumnos por apellido 1
	@Query(value = "SELECT * FROM alumnos WHERE apellido1 LIKE ?1%", nativeQuery = true)
	List<Alumno> alumnosPorApellidoUno(String apellido1);
	
	
	
	
	
	
}
