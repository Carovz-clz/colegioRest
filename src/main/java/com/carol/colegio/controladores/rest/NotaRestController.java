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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carol.colegio.dao.NotaDAO;
import com.carol.colegio.dtos.AsignaturaDTO;
import com.carol.colegio.dtos.NotaDTO;
import com.carol.colegio.entities.AlumnoEntity;
import com.carol.colegio.entities.NotaEntity;
import com.carol.colegio.repositorios.NotaRepository;

@RestController
@RequestMapping("/v1")
public class NotaRestController {

	@Autowired
	private NotaRepository notaRepository;

	@Autowired
	private NotaDAO notaDAO;

	// Obtener todas las notas
	@GetMapping(value = "/notas")
	public Iterable<NotaEntity> listarTodosLasNotas() {
		return notaRepository.findAll();
	}

	// Obtener por id
	@GetMapping(value = "/notas/{id}")
	public Optional<NotaEntity> buscarNotaPorId(@PathVariable("id") Integer id) {
		return notaRepository.findById(id);
	}

	// Obtener notas por id, nombre, curso, tasa
	@GetMapping(value = "/notas", params = { "id", "nombre", "asignatura", "nota", "fecha" })
	public List<NotaDTO> listarNotaPorIdNombreAsignaturaNotaFehca(
			@RequestParam(value = "id", required = false) Integer idAlumno,
			@RequestParam(value = "nombre", required = false) String nombreAlumno,
			@RequestParam(value = "asignatura", required = false) String asignatura,
			@RequestParam(value = "nota", required = false) Double nota,
			@RequestParam(value = "fecha", required = false) String fecha) {

		return notaDAO.obtenerNotaPorIdNombreAsignaturaNotaFecha(idAlumno, nombreAlumno, asignatura, nota, fecha);
	}

	// Insertar notas
//	@PostMapping("/notas")
//	public ResponseEntity<String> insertarNota(
//			@RequestParam ("idAlumno") Integer idAlumno,
//			@RequestParam("idAsignatura") Integer idAsignatura,
//			@RequestParam("nota") Double nota,
//			@RequestParam("fecha") String fecha){
//		
//		
//		
//		return new ResponseEntity<>("Inserción nota correcta!", HttpStatus.OK);
//	}

	// Borrar notas
	@DeleteMapping(value = "/notas/{id}")
	public ResponseEntity<String> borrarNotas(@PathVariable("id") Integer id) {

		notaRepository.deleteById(id);
		return new ResponseEntity<String>("Borrado de nota correcto!", HttpStatus.OK);
	}
}
