package com.api.api_biblioteca.persistence.repository;

import com.api.api_biblioteca.persistence.crud.LibroCrudRepository;
import com.api.api_biblioteca.persistence.entity.Genero;
import com.api.api_biblioteca.persistence.entity.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class LibroRepository {

    @Autowired
    private LibroCrudRepository libroCrudRepository;

    public List<Libro>getByTituloContaining(String titulo){
        return libroCrudRepository.findByTituloContaining(titulo);
    }

    public List<Libro>getByTitulo(String titulo){
        return libroCrudRepository.findByTitulo(titulo);
    }

    public List<Libro>getByIdAutor(int autorId){
        return libroCrudRepository.findByAutor_IdAutor(autorId);
    }

    public List<Libro>getByGenero(Genero genero){
        return libroCrudRepository.findByGenero(genero);
    }

    public List<Libro>getBooksDisponibleTrue(){
        return libroCrudRepository.findByDisponibleTrue();
    }

    public List<Libro>getByFechaPublicacionAfter(LocalDateTime now){
        return libroCrudRepository.findByFechaPublicacionAfter(now);
    }

    public List<Libro>getByFechaPublicacionBefore(LocalDateTime now){
        return libroCrudRepository.findByFechaPublicacionBefore(now);
    }

}
