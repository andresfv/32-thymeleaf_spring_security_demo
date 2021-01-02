package com.softwareValelciano.primefaces.primefacesDemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.softwareValelciano.primefaces.primefacesDemo.entity.Profesor;
import com.softwareValelciano.primefaces.primefacesDemo.service.ProfesorService;

@Component
@Scope("session")
public class ProfesorBean {

	@Autowired
	ProfesorService profesorService;

	Profesor profesorEntity;
	List<Profesor> listaProfesores;
    List<Profesor> listaProfesoresFiltrada ;
    
    @PostConstruct
    public void init() {
        profesorEntity = new Profesor();
    	listaProfesores = new ArrayList<Profesor>();
        listaProfesoresFiltrada  = new ArrayList<Profesor>();
    }
    
    
}
