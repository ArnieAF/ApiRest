package com.api.api_biblioteca.domain.service;

import com.api.api_biblioteca.domain.Author;
import com.api.api_biblioteca.domain.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAll() {
        return  authorRepository.getAll();

    }

    public List<Author>findByNameContaining(String name){
        return authorRepository.findByNameContaining(name);
    }

    public Optional<Author> findByName(String name){
        return authorRepository.findByName(name);
    }

    public List<Author> findByNationality(String nationality){
        return authorRepository.findByNationality(nationality);
    }

    public List<Author> findAllByOrderByNameAsc(){
        return authorRepository.findAllByOrderByNameAsc();
    }

    public List<Author> findAllByOrderByNameDesc(){
        return authorRepository.findAllByOrderByNameDesc();
    }

    public long countByNationality(String nationality){
        return authorRepository.countByNationality(nationality);
    }

    public Author save(Author author){
        return authorRepository.save(author);
    }

    public boolean delete(String name){
        return findByName(name).map(author ->{
            authorRepository.delete(author.getAutorId());
            return true;
        }).orElse(false);
    }
}
