package com.carol.colegio.controladores.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carol.colegio.dao.MatriculacionDAO;
import com.carol.colegio.dtos.MatriculacionDTO;
import com.carol.colegio.entities.MatriculacionEntity;
import com.carol.colegio.repositorios.MatriculaRepository;

@RestController
@RequestMapping("/v1")
public class MatriculaRestController {
	@Autowired
	private MatriculaRepository matriculaRepository;

	@Autowired
	private MatriculacionDAO matriculaDAO;

	// Obtener todas las matriculaciones
	@GetMapping(value = "/matriculaciones")
	public Iterable<MatriculacionEntity> listarTodosLasMatriculaciones() {
		return matriculaRepository.findAll();
	}

	// Obtener por id
	@GetMapping(value = "/matriculaciones/{id}")
	public Optional<MatriculacionEntity> buscarNotaPorId(@PathVariable("id") Integer id) {
		return matriculaRepository.findById(id);
	}

	// Obtener notas por id, nombre, curso, tasa
	@GetMapping(value = "/matriculaciones", params = { "idAsignatura", "nombreAsignatura", "idAlumno", "nombreAlumno", "fecha", "activo" })
	public List<MatriculacionDTO> listarNotaPorIdNombreAsignaturaNotaFehca(
			@RequestParam(value = "idAsignatura", required = false) Integer idAsig,
			@RequestParam(value = "nombreAsignatura", required = false) String nombreAsig,
			@RequestParam(value = "idAlumno", required = false) Integer idAlum,
			@RequestParam(value= "nombreAlumno", required = false) String nombreAlum,
			@RequestParam(value = "fecha", required = false) String fecha,
			@RequestParam(value = "activo", required = false) Integer activo) {

		return matriculaDAO.obtenerMatriculacionesPorIdasigNombreAsigIdalumNombrealumFechaActivo(idAsig, nombreAsig, idAlum, nombreAlum, fecha, activo);
	}
}
