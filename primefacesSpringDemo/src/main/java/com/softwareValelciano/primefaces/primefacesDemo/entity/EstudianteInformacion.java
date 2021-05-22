package com.softwareValelciano.primefaces.primefacesDemo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "estudiante_informacion")
public class EstudianteInformacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante_informacion")
    int id;

    @Column(name = "celular")
    String celular;

    @Column(name = "telefono")
    String telefono;

    @Column(name = "email")
    String email;

    @OneToOne(mappedBy = "estudianteInformacion", cascade = {CascadeType.DETACH,
        CascadeType.MERGE,
        CascadeType.PERSIST,
        CascadeType.REFRESH})
    private Estudiante estudiante;

    public EstudianteInformacion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public String toString() {
        return "EstudianteInformacion{" + "id=" + id + ", celular=" + celular + ", telefono=" + telefono + ", email=" + email + ", estudiante=" + estudiante + '}';
    }
}
