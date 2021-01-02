package com.softwareValelciano.primefaces.primefacesDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softwareValelciano.primefaces.primefacesDemo.entity.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {

}
