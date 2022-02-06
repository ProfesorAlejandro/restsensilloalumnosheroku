package com.daw.restsencillo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daw.restsencillo.model.entity.Alumno;
import com.daw.restsencillo.model.service.AlumnoService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class AlumnoRestController {

    @Autowired
    private AlumnoService alumnoService;

    //GET   ( Obtener recursos )

    @GetMapping("/list")
    public List<Alumno> list(){
        return alumnoService.listadoAlumnos();
    }
    @GetMapping("/alumno/{id}")
    public Alumno show(@PathVariable Long id){
        return alumnoService.buscarAlumnos(id);
    }


    // POST ( Crear recursos )
    @PostMapping("/save")
    public Alumno save(@RequestBody Alumno alumno){
        return  alumnoService.guardarAlumnos(alumno);

    }

    // PUT ( Modificar recursos )

    @PutMapping("/update/{id}")
    public Alumno update(@PathVariable Long id,@RequestBody Alumno alumno ){

        Alumno alumnoEncontrado = alumnoService.buscarAlumnos(id);

        alumnoEncontrado.setNombre(alumno.getNombre());
        alumnoEncontrado.setApellido1(alumno.getApellido1());
        alumnoEncontrado.setApellido2(alumno.getApellido2());
        alumnoEncontrado.setNota(alumno.getNota());

        return alumnoService.guardarAlumnos(alumnoEncontrado);
    }

    //DELETE ( Eliminar recursos )

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        alumnoService.eliminarAlumnos(id);

    }
    
    // ========================================================================
    
    
    //Alumnos suspensos
    @GetMapping("/suspensos")
    public List<Alumno> suspensos(){
    	return alumnoService.alumnosBySuspenso();
    }
    
    //Alumnos aprobados
    @GetMapping("/aprobados")
    public List<Alumno> aprobados(){
    	return alumnoService.alumnosByAprobado();
    }
    
    //Alumnos notable
    @GetMapping("/notable")
    public List<Alumno> notable(){
    	return alumnoService.alumnosByNotable();
    }
    
    
    //Alumnos sobresaliente
    @GetMapping("/sobresaliente")
    public List<Alumno> sobresaliente(){
    	return alumnoService.alumnosBySobresaliente();
    }
    
    //Alumnos por nombre
    @GetMapping("/alumno/by-name/{nombre}")
    public List<Alumno> alumnosPorNombre(@PathVariable String nombre){
    	return alumnoService.alumnosByName(nombre);
    }
    
    //Alumnos por apellido 1
    @GetMapping("/alumno/by-first-surname/{apellido1}")
    public List<Alumno> alumnosPorApellido1(@PathVariable String apellido1){
    	return alumnoService.alumnosByFirstSurname(apellido1);
    }




    



}
