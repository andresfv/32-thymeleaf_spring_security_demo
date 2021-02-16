package com.softwareValelciano.primefaces.primefacesDemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import com.softwareValelciano.primefaces.primefacesDemo.entity.Profesor;
import com.softwareValelciano.primefaces.primefacesDemo.service.ProfesorService;
import java.util.HashMap;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

@Named
public class ProfesorBean {

    @Autowired
    ProfesorService profesorService;

    Profesor profesorEntity;
    List<Profesor> listaProfesores;
    List<Profesor> listaProfesoresFiltrada;

    @PostConstruct
    public void init() {
        profesorEntity = new Profesor();
        listaProfesores = new ArrayList<Profesor>();
        listaProfesoresFiltrada = new ArrayList<Profesor>();
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

    public void newProfessor() {
        profesorEntity = new Profesor();
        Map<String, Object> options = new HashMap<String, Object>();
        options.put("width", 410);
        options.put("modal", true);
        options.put("resizable", false);
        options.put("draggable", false);
        PrimeFaces.current().dialog().openDynamic("profesorEditForm", options, null);
    }

    public void closeDialog() {
        PrimeFaces.current().dialog().closeDynamic(null);
    }

    public void save() {
        profesorService.save(profesorEntity);
        closeDialog();
    }

    public void delete() {
        profesorService.deleteById(profesorEntity.getId());
    }

    public void onReturn() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Guardado", "Registro almacenado correctamente"));
    }
}
