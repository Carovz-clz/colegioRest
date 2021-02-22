package com.carol.colegio.controladores.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carol.colegio.entities.AlumnoEntity;
import com.carol.colegio.repositorios.AlumnoRepository;

@RestController
@RequestMapping("/v1")
public class AlumnoRestController {
	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@PostMapping("/alumnos")
	public ResponseEntity<String> insertarAlumno(@RequestBody AlumnoEntity alumno){
		alumnoRepository.save(alumno);
		
		return new ResponseEntity<>("Inserción correcta!", HttpStatus.OK);
	}
}
