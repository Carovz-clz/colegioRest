package com.carol.colegio.controladores.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carol.colegio.dao.AlumnoDAO;
import com.carol.colegio.dtos.AlumnoDTO;
import com.carol.colegio.entities.AlumnoEntity;
import com.carol.colegio.repositorios.AlumnoRepository;

@RestController
@RequestMapping("/v1")
public class AlumnoRestController {
	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Autowired
	private AlumnoDAO alumnoDAO;
	
	@PostMapping("/alumnos")
	public ResponseEntity<String> insertarAlumno(@RequestBody AlumnoEntity alumno){
		alumnoRepository.save(alumno);
		
		return new ResponseEntity<>("Inserción correcta!", HttpStatus.OK);
	}
	
	//Obtener todos los alumnos
	@GetMapping(value = "/alumnos")
	public Iterable<AlumnoEntity> listarTodosLosAlumnos() {
		return alumnoRepository.findAll();
	}
	
	//Obtener por id
	@GetMapping(value = "/alumnos/{id}")
	public Optional<AlumnoEntity> buscarAlumnoPorId(@PathVariable("id") Integer id){
		return alumnoRepository.findById(id);
	}
	
	//Obtener alumnos por id y nombre
	@GetMapping(value = "/alumnos", params = {"id", "nombre"})
	public List<AlumnoDTO> listarAlumnosPorIdNombre(
			@RequestParam("id") Integer id,
			@RequestParam("nombre") String nombre){
		
		return alumnoDAO.obtenerAlumnosporIdyNombre(id, nombre);
	}
	
	//Actualizar alumnos
	@PutMapping(value = "/alumnos")
	public ResponseEntity<String> actualizarAlumno(@RequestBody AlumnoEntity alumno){
		
		alumnoRepository.save(alumno);
		
		return new ResponseEntity<>("Actualización correcta!", HttpStatus.OK);
	}
	
	//Borrar alumnos
	@DeleteMapping(value = "/alumnos/{id}")
	public ResponseEntity<String> MostrarFormularioBorrarAlumnos(@PathVariable("id") Integer id){
		
		alumnoRepository.deleteById(id);
		return new ResponseEntity<String>("Borrado correcto!", HttpStatus.OK);
	}
}
