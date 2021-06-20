/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareValelciano.primefaces.primefacesDemo.controller;

import com.softwareValelciano.primefaces.primefacesDemo.entity.Materia;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;

/**
 *
 * @author Luis Andrés Fallas Valenciano
 */
public class LazyMateriaDataModeler extends LazyDataModel<Materia> {

    private List<Materia> datasource;

    public LazyMateriaDataModeler(List<Materia> datasource) {
        this.datasource = datasource;
    }

    @Override
    public Materia getRowData(String rowKey) {
        for (Materia materia : datasource) {
            if (materia.getId() == Integer.parseInt(rowKey)) {
                return materia;
            }
        }

        return null;
    }

    @Override
    public String getRowKey(Materia materia) {
        return String.valueOf(materia.getId());
    }

    @Override
    public List<Materia> load(int offset, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
        long rowCount = datasource.stream().count();
        // apply offset & filters
        List<Materia> materias = datasource.stream()
                .skip(offset)
                .limit(pageSize)
                .collect(Collectors.toList());



        // rowCount
        setRowCount((int) rowCount);

        return materias;
    }

}
