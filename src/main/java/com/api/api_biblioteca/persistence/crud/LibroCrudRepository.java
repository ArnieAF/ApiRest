package com.api.api_biblioteca.persistence.crud;

import com.api.api_biblioteca.persistence.entity.Genero;
import com.api.api_biblioteca.persistence.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface LibroCrudRepository extends JpaRepository<Libro,Integer>{

    List<Libro>findByTituloContaining(String titulo); //Buscar libro parcialmente
    List<Libro>findByTitulo(String titulo);//Buscar libro exacto
    List<Libro>findByAutor_IdAutor(int autorId); //Buscar libros por id del autor
    List<Libro> findByGenero(Genero genero); // Buscar libros por el genero
    List<Libro>findByDisponibleTrue(); //Buscar libros disponibles
    List<Libro>findByFechaPublicacionAfter(LocalDateTime now);//Encontrar peliculas despues de una fecha
    List<Libro>findByFechaPublicacionBefore(LocalDateTime now); //Encontrar peliculas antes de uan fecha

}
