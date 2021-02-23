package com.carol.colegio.dtos;

public class TasaRequestDTO {
	private Integer idAlumno;
	private Integer idAsignatura;
	
	public TasaRequestDTO() {
		super();
	}

	public TasaRequestDTO(Integer idAlumno, Integer idAsignatura) {
		super();
		this.idAlumno = idAlumno;
		this.idAsignatura = idAsignatura;
	}

	public Integer getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}

	public Integer getIdAsignatura() {
		return idAsignatura;
	}

	public void setIdAsignatura(Integer idAsignatura) {
		this.idAsignatura = idAsignatura;
	}
	
	
	
}
