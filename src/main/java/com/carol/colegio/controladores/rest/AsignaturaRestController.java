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

import com.carol.colegio.dao.AsignaturaDAO;
import com.carol.colegio.dtos.AsignaturaDTO;
import com.carol.colegio.entities.AsignaturaEntity;
import com.carol.colegio.repositorios.AsignaturaRepository;

@RestController
@RequestMapping("/v1")
public class AsignaturaRestController {
	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	@Autowired
	private AsignaturaDAO asignaturaDAO;
	
	@PostMapping("/asignaturas")
	public ResponseEntity<String> insertarAsignatura(@RequestBody AsignaturaEntity asignatura){
		asignaturaRepository.save(asignatura);
		
		return new ResponseEntity<>("Inserción de asignatura correcta!", HttpStatus.OK);
	}
	
	//Obtener alumnos por id y nombre
	@GetMapping(value = "/asignaturas", params = {"id", "nombre", "curso", "tasa"})
	public List<AsignaturaDTO> listarAsignaturaPorIdNombreCursoTasa(
			@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value ="nombre", required = false) String nombre,
			@RequestParam(value ="curso", required = false) Integer curso,
			@RequestParam(value ="tasa", required = false) Double tasa){
		
		return asignaturaDAO.obtenerAsignaturaPorIdNombreCursoTasa(id, nombre, curso, tasa);
	}
	
	//Actualizar alumnos
	@PutMapping(value = "/asignaturas")
	public ResponseEntity<String> actualizarAsignatura(@RequestBody AsignaturaEntity asignatura){
		
		asignaturaRepository.save(asignatura);
		
		return new ResponseEntity<>("Actualización de asignatura correcta!", HttpStatus.OK);
	}
	
	//Borrar alumnos
	@DeleteMapping(value = "/asignaturas/{id}")
	public ResponseEntity<String> MostrarFormularioBorrarAsignaturas(@PathVariable("id") Integer id){
		
		asignaturaRepository.deleteById(id);
		return new ResponseEntity<String>("Borrado de la asignatura correcto!", HttpStatus.OK);
	}
}
