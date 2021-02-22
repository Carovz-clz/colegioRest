package com.carol.colegio.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.carol.colegio.dtos.MatriculacionDTO;
import com.carol.colegio.entities.MatriculacionEntity;

@Repository
public interface MatriculaRepository extends CrudRepository<MatriculacionEntity, Integer> {
	
	@Query(value = "select new com.carol.colegio.dtos.MatriculacionDTO (m.id, asig.id, asig.nombre, a.id, a.nombre, m.fecha, m.activo) "
	 		+ "FROM com.carol.colegio.entities.MatriculacionEntity m JOIN com.carol.colegio.entities.AsignaturaEntity asig ON m.asignaturas.id = asig.id "
	 		+ "JOIN com.carol.colegio.entities.AlumnoEntity a ON m.alumnos.id = a.id "
	 		+ "WHERE (asig.id LIKE CONCAT('%',:idAsig,'%') or :idAsig is null) "
	 		+ "AND asig.nombre LIKE CONCAT ('%',:nombreAsig,'%') "
	 		+ "AND (a.id LIKE CONCAT('%',:idAlum,'%') or :idAlum is null) "
	 		+ "AND a.nombre LIKE CONCAT ('%',:nombreAlum,'%') "
	 		+ "AND (m.fecha LIKE CONCAT('%',:fecha,'%') or :fecha is null) "
	 		+ "AND (m.activo = :activo) ")
		List<MatriculacionDTO> obtenerMatriculacionesPorIdasigNombreAsigIdalumNombrealumFechaActivo(
				@Param("idAsig") Integer idAsig,
				@Param("nombreAsig") String nombreAsig,
				@Param("idAlum") Integer idAlum,
				@Param("nombreAlum") String nombreAlum,
				@Param("fecha") String fecha,
				@Param("activo") Integer activo);
	
	@Query(value = "SELECT count(*) FROM com.carol.colegio.entities.MatriculacionEntity m where m.alumnos.id = :idAlumno")
	int obtenerNumeroAsignaturasmatriculadas(@Param("idAlumno") Integer idAlumno);
	
	
}
