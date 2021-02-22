package com.carol.colegio.dao;

import java.util.List;

import com.carol.colegio.dtos.MatriculacionDTO;

public interface MatriculacionDAO {
	List<MatriculacionDTO> obtenerMatriculacionesPorIdasigNombreAsigIdalumNombrealumFechaActivo(Integer idAsig, String nombreAsig, Integer idAlum, String nombreAlum, String fecha, Integer activo);
	Integer insertarMatriculacion(Integer indAlumno, Integer idAsignatura, Double tasa, String fecha);
	Integer borrarMatriculacion(Integer idMatricula);
}
