package com.carol.colegio.dtos;

public class NotaRequestDTO {
	private Integer idAlumno;
	private Integer idAsignatura;
	private Double nota;
	private String fecha;
	
	public NotaRequestDTO() {
		super();
	}

	public NotaRequestDTO(Integer idAlumno, Integer idAsignatura, Double nota, String fecha) {
		super();
		this.idAlumno = idAlumno;
		this.idAsignatura = idAsignatura;
		this.nota = nota;
		this.fecha = fecha;
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

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	
}
