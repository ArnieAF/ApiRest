package com.api.api_biblioteca.persistence.repository;

import com.api.api_biblioteca.domain.repository.AuthorRepository;
import com.api.api_biblioteca.domain.service.Author;
import com.api.api_biblioteca.persistence.crud.AutorCrudRepository;
import com.api.api_biblioteca.persistence.entity.Autor;
import com.api.api_biblioteca.persistence.mapper.AuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AutorRepository implements AuthorRepository {

    @Autowired
    private AutorCrudRepository autorCrudRepository;

    @Autowired
    private AuthorMapper mapper;

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

    @Override
    public List<Author> getAll() {
        List<Autor>autores = (List<Autor>) autorCrudRepository.findAll();
        return mapper.toAuthors(autores);
    }

    @Override
    public List<Author> findByNameContaining(String name) {
        List<Autor>autores = autorCrudRepository.findByNombreContaining(name);
        return autores;
    }

    @Override
    public Optional<Author> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Author> findByNationality(String nationality) {
        return List.of();
    }

    @Override
    public List<Author> findAllByOrderByNameAsc() {
        return List.of();
    }

    @Override
    public List<Author> findAllByOrderByNameDesc() {
        return List.of();
    }

    @Override
    public long countByNationality(String nationality) {
        return 0;
    }

    @Override
    public Author save(Author author) {
        return null;
    }

    @Override
    public void delete(int authorId) {

    }
}
