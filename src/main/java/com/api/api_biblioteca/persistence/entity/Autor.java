package com.api.api_biblioteca.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAutor",nullable = false)
    private Integer idAutor;

    @Column(name = "nombre") // Verifica también este nombre
    private String nombre;

    @Column(name = "nacionalidad") // Verifica también este nombre
    private String nacionalidad;

    public Integer getIdAutor() {
        return idAutor;
    }

    public Autor() {
    }
    public Autor(Integer idAutor, String nombre, String nacionalidad) {
        this.idAutor = idAutor;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public void setIdAutor(Integer idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }


    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}
