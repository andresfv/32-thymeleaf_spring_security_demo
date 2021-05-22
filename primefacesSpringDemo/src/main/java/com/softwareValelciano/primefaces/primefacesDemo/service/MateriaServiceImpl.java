package com.softwareValelciano.primefaces.primefacesDemo.service;

import com.softwareValelciano.primefaces.primefacesDemo.dao.MateriaRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softwareValelciano.primefaces.primefacesDemo.entity.Materia;

@Service
public class MateriaServiceImpl implements MateriaService {

	@Autowired
    MateriaRepository materiaRepository;

    @Override
    public List<Materia> findAll() {
        return materiaRepository.findAll();
    }

    @Override
    public void save(Materia materia) {
        materiaRepository.save(materia);
    }

    @Override
    public void deleteById(int idMateria) {
        materiaRepository.deleteById(idMateria);
    }


}
