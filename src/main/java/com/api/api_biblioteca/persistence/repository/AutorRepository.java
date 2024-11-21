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

    @Override
    public List<Author>getAll(){
        List<Autor>autores = (List<Autor>) autorCrudRepository.findAll();
        return mapper.toAuthors(autores);
    }

    @Override
    public List<Author> findByNameContaining(String name) {
        List<Autor>autores = autorCrudRepository.findByNombreContaining(name);
        return mapper.toAuthors(autores);
    }

    @Override
    public Optional<Author> findByName(String name) {
        Optional<Autor>autor =  autorCrudRepository.findByNombre(name);
        return autor.map(autor1 -> mapper.toAuthor(autor1));
    }

    @Override
    public List<Author> findByNationality(String nationality) {
        List<Autor>autores = autorCrudRepository.findByNacionalidad(nationality);
        return mapper.toAuthors(autores);
    }


    @Override
    public List<Author> findAllByOrderByNameAsc() {
        List<Autor> autores = autorCrudRepository.findAllByOrderByNombreAsc();
        return mapper.toAuthors(autores);
    }

    @Override
    public List<Author> findAllByOrderByNameDesc() {
        List<Autor> autores = autorCrudRepository.findAllByOrderByNombreDesc();
        return mapper.toAuthors(autores);
    }

    @Override
    public long countByNationality(String nationality) {
        return autorCrudRepository.countByNacionalidad(nationality);
    }


    @Override
    public Author save(Author author) {
        Autor autor = mapper.toAutor(author);
        return mapper.toAuthor(autorCrudRepository.save(autor));
    }

    @Override
    public void delete(int authorId) {
        autorCrudRepository.deleteById(authorId);
    }

}
