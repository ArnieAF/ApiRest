package com.api.api_biblioteca.persistence.repository;

import com.api.api_biblioteca.persistence.crud.AutorCrudRepository;
import com.api.api_biblioteca.persistence.entity.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AutorRepository {

    @Autowired
    private AutorCrudRepository autorCrudRepository;

    public List<Autor>getByNombreContaining(String nombre){
        return autorCrudRepository.findByNombreContaining(nombre);
    }

    public List<Autor>getByNombre(String nombre){
        return  autorCrudRepository.findByNombre(nombre);
    }

    public List<Autor>getByNacionalidad(String nacionalidad){
        return  autorCrudRepository.findByNacionalidad(nacionalidad);
    }

   public List<Autor>getAllAsc(){
        return  autorCrudRepository.findAllByOrderByNombreAsc();
   }

   public List<Autor>getAllDesc(){
        return autorCrudRepository.findAllByOrderByNombreDesc();
   }

   public long getAutorPorPais(String pais){
        return autorCrudRepository.countByNacionalidad(pais);
   }

}
