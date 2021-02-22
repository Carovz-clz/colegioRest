package com.carol.colegio.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.carol.colegio.dtos.NotaDTO;
import com.carol.colegio.entities.NotaEntity;

@Repository
public interface NotaRepository extends CrudRepository<NotaEntity, Integer>{
	@Query(value = "select new com.carol.colegio.dtos.NotaDTO (n.id, a.id, a.nombre, asig.id, asig.nombre, n.nota, n.fecha) "
			+ "FROM com.carol.colegio.entities.NotaEntity n JOIN com.carol.colegio.entities.AlumnoEntity a ON n.alumnos.id = a.id "
			+ "JOIN com.carol.colegio.entities.AsignaturaEntity asig ON n.asignaturas.id = asig.id "
			+ "WHERE (a.id LIKE CONCAT('%',:idAlumno,'%') or :idAlumno is null) "
			+ "AND a.nombre LIKE CONCAT ('%',:nombre,'%') "
			+ "AND asig.nombre LIKE CONCAT ('%',:asignatura,'%') "
			+ "AND (n.nota LIKE CONCAT ('%',:nota,'%' ) or :nota is null ) "
			+ "AND n.fecha LIKE CONCAT ('%',:fecha,'%') or :fecha is null")
			  List<NotaDTO> obtenerNotaPorIdNombreAsignaturaNotaFecha(
					  @Param("idAlumno") Integer idAlumno,
					  @Param("nombre") String nombre,
					  @Param("asignatura") String asignatura,
					  @Param("nota") Double nota,
					  @Param("fecha") String fecha);
	
	@Query(value = "select new com.carol.colegio.dtos.NotaDTO (n.id, a.id, a.nombre, asig.id, asig.nombre, n.nota, n.fecha) "
			+ "FROM com.carol.colegio.entities.NotaEntity n JOIN com.carol.colegio.entities.AlumnoEntity a ON n.alumnos.id = a.id "
			+ "JOIN com.carol.colegio.entities.AsignaturaEntity asig ON n.asignaturas.id = asig.id "
			+ "AND a.nombre LIKE CONCAT ('%',:nombre,'%') "
			+ "AND asig.nombre LIKE CONCAT ('%',:asignatura,'%') "
			+ "AND n.fecha LIKE CONCAT ('%',:fecha,'%') or :fecha is null")
			  List<NotaDTO> obtenerNotaPorNombreAsignaturaFecha(
					  @Param("nombre") String nombre,
					  @Param("asignatura") String asignatura,
					  @Param("fecha") String fecha);
}
