package com.carol.colegio.controladores.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carol.colegio.dao.ComboDAO;
import com.carol.colegio.dtos.ComboDTO;

@RestController
@RequestMapping("/combos")
public class ComboRestController {
	
	@Autowired
	private ComboDAO comboDAO;
	
	@PostMapping("/municipios")
	public List<ComboDTO> comboMunicipios(){
		return comboDAO.comboMunicipios();
	}
	
	@PostMapping("/alumnos")
	public List<ComboDTO> comboAlumnos(){
		return comboDAO.comboAlumnos();
	}
	
	@PostMapping("/asignaturas")
	public List<ComboDTO> comboAsignaturas(){
		return comboDAO.comboAsignaturas();
	}
	
	
	
}
