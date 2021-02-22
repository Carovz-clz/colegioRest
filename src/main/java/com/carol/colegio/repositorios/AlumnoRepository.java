package com.carol.colegio.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.carol.colegio.dtos.AlumnoDTO;
import com.carol.colegio.entities.AlumnoEntity;

@Repository
public interface AlumnoRepository extends CrudRepository<AlumnoEntity, Integer>{
	
	@Query(value = "select new com.carol.colegio.dtos.AlumnoDTO (a.id, a.nombre, m.nombre, m.idMunicipio, a.famNumerosa) "
			+ "FROM com.carol.colegio.entities.AlumnoEntity a, com.carol.colegio.entities.MunicipioEntity  m "
			+ "WHERE a.idMunicipio = m.idMunicipio "
			+ "AND (a.id LIKE CONCAT('%',:id,'%') or :id is null) "
			+ "AND a.nombre LIKE CONCAT ('%',:nombre,'%') ")
			  List<AlumnoDTO>buscaAlumnoporIDyNombre(@Param("id") Integer id, @Param("nombre")String nombre);
	
}
