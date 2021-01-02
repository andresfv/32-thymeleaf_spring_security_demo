package com.softwareValelciano.primefaces.primefacesDemo.service;

import java.util.List;

import com.softwareValelciano.primefaces.primefacesDemo.entity.Profesor;

public interface ProfesorService {

	public List<Profesor> findAll();

	public void save(Profesor profesor);

	public void deleteById(int idProfesor);
	
}
