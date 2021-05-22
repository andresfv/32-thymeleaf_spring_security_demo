package com.softwareValelciano.primefaces.primefacesDemo.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    int id;

    @Column(name = "nombre")
    String nombre;

    @Column(name = "primer_apellido")
    String primerApellido;

    @Column(name = "segundo_apellido")
    String segundoApellido;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "estudiante_informacion")
    EstudianteInformacion estudianteInformacion;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.PERSIST,
                CascadeType.REFRESH})
    @JoinTable(name = "curso_estudiante",
            joinColumns = @JoinColumn(name = "estudiante"), //el orden de los campos varia, en esta clase el joinColumn es estudiante pero en la clase curso es curso
            inverseJoinColumns = @JoinColumn(name = "curso"))
    private List<Curso> cursos;


    public Estudiante() {
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

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

}
