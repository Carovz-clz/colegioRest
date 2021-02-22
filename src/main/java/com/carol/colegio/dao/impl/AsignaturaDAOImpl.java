package com.carol.colegio.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carol.colegio.dao.AsignaturaDAO;
import com.carol.colegio.dtos.AsignaturaDTO;
import com.carol.colegio.entities.AsignaturaEntity;
import com.carol.colegio.repositorios.AsignaturaRepository;
import com.carol.colegio.repositorios.MatriculaRepository;

@Service
public class AsignaturaDAOImpl implements AsignaturaDAO {
	
	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	@Autowired
	private MatriculaRepository matriculaRepository;

	@Override
	public List<AsignaturaDTO> obtenerAsignaturaPorIdNombreCursoTasa(Integer id, String nombre, Integer curso,
			Double tasa) {
		
		return asignaturaRepository.buscaAsignaturaPorIdNombreCursoTasa(id, nombre, curso, tasa);
	}

	@Override
	public Integer insertarAsignatura(Integer id, String nombre, Integer curso, Double tasa) {
		
		AsignaturaEntity asignatura = new AsignaturaEntity(id, nombre, curso, tasa);		
		asignaturaRepository.save(asignatura);
		
		return 1;  
	}

	@Override
	public Integer actualizarAsignatura(Integer id, String nombre, Integer curso, Double tasa) {
		
		AsignaturaEntity asignatura = new AsignaturaEntity(id, nombre, curso, tasa);	
		asignaturaRepository.save(asignatura);
		
		return 1;
	}

	@Override
	public Integer eliminarAsignatura(Integer id) {
		asignaturaRepository.deleteById(id);
		return 1;
	}

	@Override
	public int obtenerNumeroAsignaturasMatriculadas(Integer idAlumno) {		
		return matriculaRepository.obtenerNumeroAsignaturasmatriculadas(idAlumno);
	}

	@Override
	public double obtenerTasaAsignatura(Integer idAsignatura) {
		Optional<AsignaturaEntity> asig = asignaturaRepository.findById(idAsignatura);
		AsignaturaEntity asignatura = asig.get();
		
		return asignatura.getTasa();
	}

}
