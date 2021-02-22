package com.softwareValelciano.primefaces.primefacesDemo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "profesor")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor")
    int id;

    @Column(name = "nombre")
    String nombre;

    @Column(name = "primer_apellido")
    String primerApellido;

    @Column(name = "segundo_apellido")
    String segundoApellido;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profesor_informacion")
    ProfesorInformacion profesorInformacion;

    public Profesor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public ProfesorInformacion getProfesorInformacion() {
        return profesorInformacion;
    }

    public void setProfesorInformacion(ProfesorInformacion profesorInformacion) {
        this.profesorInformacion = profesorInformacion;
    }

    @Override
    public String toString() {
        return "Profesor [id=" + id + ", nombre=" + nombre + ", primerApellido=" + primerApellido + ", segundoApellido="
                + segundoApellido + ", profesorInformacion=" + profesorInformacion + "]";
    }
}
