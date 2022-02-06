package com.daw.restsencillo.model.service;

import com.daw.restsencillo.model.dao.IAlumnoDAO;
import com.daw.restsencillo.model.entity.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService {

    @Autowired
    private IAlumnoDAO alumnoDAO;

    //Listar todos los alumnos
    public List<Alumno> listadoAlumnos(){
        return alumnoDAO.findAll();
    }

    //Buscar alumnos por su id
    public Alumno buscarAlumnos(Long id){
        return alumnoDAO.findById(id).orElse(null);
    }

    //Guardar alumnos
    public Alumno guardarAlumnos(Alumno alumno){
        return alumnoDAO.save(alumno);
    }

    //Eliminar alumnos
    public void eliminarAlumnos(Long id){
        alumnoDAO.deleteById(id);
    }
    
    //Listar alumnos suspensos
    public List<Alumno> alumnosBySuspenso(){
    	return alumnoDAO.alumnosSupensos();
    	
    }
    
    //Listar alumnos aprobados
    public List<Alumno> alumnosByAprobado(){
    	return alumnoDAO.alumnosAprobados();
    	
    }
    
    //Listar alumnos notable
    public List<Alumno> alumnosByNotable(){
    	return alumnoDAO.alumnosNotable();
    }
    
    //Listar alumnos sobresaliente
    public List<Alumno> alumnosBySobresaliente(){
    	return alumnoDAO.alumnosSobresaliente();
    }
    
    //Listar alumnos por nombre
    public List<Alumno> alumnosByName(String nombre){
    	return alumnoDAO.alumnosPorNombre(nombre);
    }
    
    //Listar alumnos por apellido 1
    public List<Alumno> alumnosByFirstSurname(String apellido1){
    	return alumnoDAO.alumnosPorApellidoUno(apellido1);
    }
    
 






}
