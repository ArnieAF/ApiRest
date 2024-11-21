package com.api.api_biblioteca.persistence.crud;

import com.api.api_biblioteca.persistence.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AutorCrudRepository extends JpaRepository <Autor,Integer>{

    List<Autor>findByNombreContaining(String nombre); //Encuentra autor por nombre parcialmente
    Optional<Autor> findByNombre(String nombre); //Encuentra autor exacto por nombre
    List<Autor>findByNacionalidad(String pais); //Encuentra por pais
    List<Autor>findAllByOrderByNombreAsc(); //Lista todos los autores de manera ascendente
    List<Autor>findAllByOrderByNombreDesc(); //Lista todos los autores de manera descendente
    long countByNacionalidad(String pais); // Contar autores por nacionalidad

}
