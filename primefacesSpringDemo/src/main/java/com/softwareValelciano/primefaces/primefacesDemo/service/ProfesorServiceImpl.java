package com.softwareValelciano.primefaces.primefacesDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softwareValelciano.primefaces.primefacesDemo.dao.ProfesorRepository;
import com.softwareValelciano.primefaces.primefacesDemo.entity.Profesor;

@Service
public class ProfesorServiceImpl implements ProfesorService {

	@Autowired
	ProfesorRepository profesorRepository;
	
	@Override
	public List<Profesor> findAll() {
		return profesorRepository.findAll();
	}

	@Override
	public void save(Profesor profesor) {
		profesorRepository.save(profesor);
	}

	@Override
	public void deleteById(int idProfesor) {
		profesorRepository.deleteById(idProfesor);
	}

}
