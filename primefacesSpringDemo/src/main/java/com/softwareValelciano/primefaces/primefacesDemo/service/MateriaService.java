package com.softwareValelciano.primefaces.primefacesDemo.service;

import com.softwareValelciano.primefaces.primefacesDemo.entity.Materia;
import java.util.List;
import java.util.Map;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.SortMeta;

public interface MateriaService {

    public List<Materia> findAll();

    public void save(Materia materia);

    public void deleteById(int idMateria);

    public List<Materia> findCursosActivos(int pageNumber, int pageSize, Map<String, SortMeta> sort, Map<String, FilterMeta> filterBy);

    public long countCursosActivos(Map<String, FilterMeta> filterBy);
}
