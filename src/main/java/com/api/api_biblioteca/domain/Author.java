package com.api.api_biblioteca.domain;

public class Author {

    private int autorId;
    private String name;
    private String nacionality;


    public Author(int autorId, String name, String nacionality) {
        this.autorId = autorId;
        this.name = name;
        this.nacionality = nacionality;
    }

    public int getAutorId() {
        return autorId;
    }

    public void setAutorId(int autorId) {
        this.autorId = autorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNacionality() {
        return nacionality;
    }

    public void setNacionality(String nacionality) {
        this.nacionality = nacionality;
    }
}
