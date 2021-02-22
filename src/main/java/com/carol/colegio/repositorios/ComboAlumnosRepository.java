package com.carol.colegio.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.carol.colegio.entities.AlumnoEntity;

public interface ComboAlumnosRepository extends CrudRepository<AlumnoEntity, Integer> {

}
