package com.api.api_biblioteca.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Genero")
public class  Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGenero;

    private String nombre;

    public Integer getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Integer idGenero) {
        this.idGenero = idGenero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
