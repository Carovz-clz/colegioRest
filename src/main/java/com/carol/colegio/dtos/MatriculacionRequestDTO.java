package com.carol.colegio.dtos;

public class MatriculacionRequestDTO {
	private Integer id;
	private Integer idAsignatura;
	private Integer idAlumno;
	private String fecha;
	private Double tasa;
	
	public MatriculacionRequestDTO() {
		super();
	}

	public MatriculacionRequestDTO(Integer idAsignatura, Integer idAlumno, String fecha, Double tasa) {
		super();
		this.idAsignatura = idAsignatura;
		this.idAlumno = idAlumno;
		this.fecha = fecha;
		this.tasa = tasa;
	}
	
	

	public MatriculacionRequestDTO(Integer id, Integer idAsignatura, Integer idAlumno, String fecha, Double tasa) {
		super();
		this.id = id;
		this.idAsignatura = idAsignatura;
		this.idAlumno = idAlumno;
		this.fecha = fecha;
		this.tasa = tasa;
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdAsignatura() {
		return idAsignatura;
	}

	public void setIdAsignatura(Integer idAsignatura) {
		this.idAsignatura = idAsignatura;
	}

	public Integer getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Double getTasa() {
		return tasa;
	}

	public void setTasa(Double tasa) {
		this.tasa = tasa;
	}
	
	
	
}
