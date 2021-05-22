package com.softwareValelciano.primefaces.primefacesDemo.dao;

import com.softwareValelciano.primefaces.primefacesDemo.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
