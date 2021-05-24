package com.softwareValelciano.primefaces.primefacesDemo.controller;

import com.softwareValelciano.primefaces.primefacesDemo.entity.Materia;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import com.softwareValelciano.primefaces.primefacesDemo.service.MateriaService;
import java.util.HashMap;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

@Named
public class MateriaBean {

    @Autowired
    MateriaService materiaService;

    Materia materiaEntity;
    List<Materia> listaMaterias;
    List<Materia> listaMateriasFiltrada;
    FacesMessage message;

    @PostConstruct
    public void init() {
        materiaEntity = new Materia();
        listaMaterias = new ArrayList<Materia>();
        listaMateriasFiltrada = new ArrayList<Materia>();
    }

    public void initDetails() {
        listaMaterias = materiaService.findAll();
        listaMateriasFiltrada = listaMaterias;
    }

    public Materia getMateriaEntity() {
        return materiaEntity;
    }

    public void setMateriaEntity(Materia materiaEntity) {
        this.materiaEntity = materiaEntity;
    }

    public List<Materia> getListaMaterias() {
        return listaMaterias;
    }

    public void setListaMaterias(List<Materia> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }

    public List<Materia> getListaMateriasFiltrada() {
        return listaMateriasFiltrada;
    }

    public void setListaMateriasFiltrada(List<Materia> listaMateriasFiltrada) {
        this.listaMateriasFiltrada = listaMateriasFiltrada;
    }

    public void newMateria() {
        materiaEntity = new Materia();
        openDialog();
    }

    public void openDialog() {
        Map<String, Object> options = new HashMap<String, Object>();
        options.put("width", 500);
        options.put("height", 500);
        options.put("modal", true);
        options.put("resizable", false);
        options.put("draggable", false);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        PrimeFaces.current().dialog().openDynamic("materiaEditForm", options, null);
    }

    public void closeDialog() {
        PrimeFaces.current().dialog().closeDynamic(null);
        message = null;
    }

    public void save() {
        materiaService.save(materiaEntity);
        closeDialog();
        message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardado", "Registro guardado correctamente");
    }

    public void delete() {
        materiaService.deleteById(materiaEntity.getId());
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Eliminado", "Registro eliminado correctamente"));
        context.getExternalContext().getFlash().setKeepMessages(true);
    }

    public void onReturn() {
        if (message != null) {
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
}
