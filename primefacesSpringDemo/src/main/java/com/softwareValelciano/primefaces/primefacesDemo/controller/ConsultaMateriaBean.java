package com.softwareValelciano.primefaces.primefacesDemo.controller;

import com.softwareValelciano.primefaces.primefacesDemo.entity.Materia;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import com.softwareValelciano.primefaces.primefacesDemo.service.MateriaService;
import java.util.Map;
import javax.faces.application.FacesMessage;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;

@Named
public class ConsultaMateriaBean {

    @Autowired
    MateriaService materiaService;


    Materia materiaEntity;
    List<Materia> listaMaterias;
    FacesMessage message;

    private LazyDataModel<Materia> lazyModel;

    @PostConstruct
    public void init() {
        materiaEntity = new Materia();
        listaMaterias = new ArrayList<Materia>();

    }

    public void initDetails() {
        listaMaterias = materiaService.findAll();
    }

    public void initDetailsConsulta() {
        //lazyModel = new LazyMateriaDataModeler(materiaService.findCursosActivos());

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

    public LazyDataModel<Materia> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<Materia> lazyModel) {
        this.lazyModel = lazyModel;
    }


    @PostConstruct
    public void lazyLoad() {
        lazyModel = new LazyDataModel<Materia>() {
            @Override
            public List<Materia> load(int offset, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
//                long rowCount = materiaService.findCursosActivos(offset, pageSize).stream().count();
                long rowCount = materiaService.countCursosActivos(filterBy);

                // apply offset & filters
//                List<Materia> materias = materiaService.findCursosActivos(offset, pageSize).stream()
//                        .skip(offset)
//                        .limit(pageSize)
//                        .collect(Collectors.toList());
                List<Materia> materias = materiaService.findCursosActivos(offset, pageSize, sortBy, filterBy);

                System.out.println("offset: " + offset + "\n" + "tamaño de pagina: " + pageSize + "\n" + "Sort By" + sortBy + "\n" + "filterBy" + filterBy);

                // Setea el número total de filas de la consulta para establecer la ultima pagina
                setRowCount((int) rowCount);

                return materias;
            }
        };
    }

//    public void cargarMaterias() {
//        try {
//            System.out.println("<<<<<<<<<<<<Iniciando cargado de materias de relleno>>>>>>>>>>>>");
//            for (int i = 14; i < 5001; i++) {
//                Materia materiaRelleno = new Materia();
//            materiaRelleno.setNombre("Materia Relleno " + i);
//            materiaRelleno.setDescripcion("Materia Relleno " + i);
//            materiaRelleno.setCreditos(0);
//            materiaRelleno.setActiva(true);
//                System.out.println("<<<<<<<<<<Procediendo a guardar la Materia de Relleno " + i + ">>>>>>>");
//            materiaService.save(materiaRelleno);
//            System.out.println("<<<<<<<<<<Materia Relleno " + i + " guardada>>>>>>>");
//        }
//            System.out.println("<<<<<<<<<<<<Tarea finalizada>>>>>>>>>>>>");
//        } catch (Exception e) {
//            System.out.println("<<<<<<<<<<<<Se presentó un error: " + e + " >>>>>>>>>>>");
//        }
//    }
}
