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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    int id;

    @Column(name = "codigo")
    String codigo;

    @Column(name = "activa")
    boolean activa;

    @ManyToOne(cascade = {CascadeType.DETACH,
        CascadeType.MERGE,
        CascadeType.PERSIST,
        CascadeType.REFRESH})
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;

    @ManyToOne(cascade = {CascadeType.DETACH,
        CascadeType.MERGE,
        CascadeType.PERSIST,
        CascadeType.REFRESH})
    @JoinColumn(name = "id_materia")
    private Materia materia;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.PERSIST,
                CascadeType.REFRESH})
    @JoinTable(name = "curso_estudiante",
            joinColumns = @JoinColumn(name = "curso"),//el orden de los campos varia, en esta clase el joinColumn es curso pero en la clase estudiante es estudiante
            inverseJoinColumns = @JoinColumn(name = "estudiante"))
    private List<Estudiante> estudiantes;

    public Curso() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }


    @Override
    public String toString() {
        return "Curso{" + "id=" + id + ", codigo=" + codigo + ", activa=" + activa + ", profesor=" + profesor + '}';
    }

}
