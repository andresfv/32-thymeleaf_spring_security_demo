package com.softwareValelciano.primefaces.primefacesDemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import com.softwareValelciano.primefaces.primefacesDemo.entity.Profesor;
import com.softwareValelciano.primefaces.primefacesDemo.service.ProfesorService;

@Named
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
    
    public void initDetails() {
    	listaProfesores = profesorService.findAll();
    	listaProfesoresFiltrada = listaProfesores;
    }
    
	public Profesor getProfesorEntity() {
		return profesorEntity;
	}

	public void setProfesorEntity(Profesor profesorEntity) {
		this.profesorEntity = profesorEntity;
	}
    
    public List<Profesor> getListaProfesores() {
		return listaProfesores;
	}

	public void setListaProfesores(List<Profesor> listaProfesores) {
		this.listaProfesores = listaProfesores;
	}

	public List<Profesor> getListaProfesoresFiltrada() {
		return listaProfesoresFiltrada;
	}

	public void setListaProfesoresFiltrada(List<Profesor> listaProfesoresFiltrada) {
		this.listaProfesoresFiltrada = listaProfesoresFiltrada;
	}

    
    public String save() {
    	profesorService.save(profesorEntity);
    	profesorEntity = new Profesor();
    	return "/profesorListForm.xhtml?faces-redirect=true";
    }
}
