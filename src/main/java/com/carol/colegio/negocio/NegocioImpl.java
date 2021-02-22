package com.carol.colegio.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carol.colegio.dao.AlumnoDAO;
import com.carol.colegio.dao.AsignaturaDAO;

@Service
public class NegocioImpl implements INegocio {
	@Autowired
	private AsignaturaDAO asignaturaImpl;
	
	@Autowired
	private AlumnoDAO alumnoImpl;

	@Override
	public Double calcularTasa(Integer idAlumno, Integer idAsignatura) {
		
		int numAsigMatriculadas = asignaturaImpl.obtenerNumeroAsignaturasMatriculadas(idAlumno); 
		Double tasa = asignaturaImpl.obtenerTasaAsignatura(idAsignatura);
		
		if ((numAsigMatriculadas >= 3) && (numAsigMatriculadas <= 5)) { //70%
			tasa = tasa * 0.7;
		}else if(numAsigMatriculadas >= 6) { //50%
			tasa = tasa * 0.5;
		}
		
		if(alumnoImpl.esFamiliaNumerosa(idAlumno)) {//Si es un alumno con familia numerosa -> 50%
			tasa = tasa * 0.5; 
		}		
		
		return tasa;
	}

}
