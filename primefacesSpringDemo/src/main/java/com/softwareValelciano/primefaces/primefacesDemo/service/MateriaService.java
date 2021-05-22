package com.softwareValelciano.primefaces.primefacesDemo.service;

import com.softwareValelciano.primefaces.primefacesDemo.entity.Materia;
import java.util.List;

public interface MateriaService {

    public List<Materia> findAll();

    public void save(Materia materia);

    public void deleteById(int idMateria);
	
}
