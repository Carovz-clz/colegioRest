package com.carol.colegio.dao;

import java.util.List;

import com.carol.colegio.dtos.ComboDTO;

public interface ComboDAO {
	List<ComboDTO> comboMunicipios();
	List<ComboDTO> comboAlumnos();
	List<ComboDTO> comboAsignaturas();
}
