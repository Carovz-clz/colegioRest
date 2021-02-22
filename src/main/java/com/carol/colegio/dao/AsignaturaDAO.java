package com.carol.colegio.dao;

import java.util.List;

import com.carol.colegio.dtos.AsignaturaDTO;

public interface AsignaturaDAO {
	List<AsignaturaDTO> obtenerAsignaturaPorIdNombreCursoTasa(Integer id, String nombre, Integer curso, Double tasa);
	Integer insertarAsignatura(Integer id, String nombre, Integer curso, Double tasa);
	Integer actualizarAsignatura(Integer id, String nombre, Integer curso, Double tasa);
	Integer eliminarAsignatura(Integer id);
	int obtenerNumeroAsignaturasMatriculadas(Integer idAlumno);
	double obtenerTasaAsignatura(Integer idAsignatura);
}
