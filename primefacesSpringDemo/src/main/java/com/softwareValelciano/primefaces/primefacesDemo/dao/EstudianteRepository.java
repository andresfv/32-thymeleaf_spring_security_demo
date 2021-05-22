package com.softwareValelciano.primefaces.primefacesDemo.dao;

import com.softwareValelciano.primefaces.primefacesDemo.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {

}
