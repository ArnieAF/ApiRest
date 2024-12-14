package com.api.api_biblioteca.controller;

import com.api.api_biblioteca.domain.Author;
import com.api.api_biblioteca.domain.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;



    @GetMapping("/all")
    public List<Author> getAll() {
        return authorService.getAll();
    }

    @GetMapping("/{nameC}")
    public List<Author>findByNameContaining(@PathVariable("nameC") String name){
        return authorService.findByNameContaining(name);
    }

    public Optional<Author> findByName(String name){
        return authorService.findByName(name);
    }

    public List<Author> findByNationality(String nationality){
        return authorService.findByNationality(nationality);
    }

    public List<Author> findAllByOrderByNameAsc(){
        return authorService.findAllByOrderByNameAsc();
    }

    public List<Author> findAllByOrderByNameDesc(){
        return authorService.findAllByOrderByNameDesc();
    }

    public long countByNationality(String nationality){
        return authorService.countByNationality(nationality);
    }

    public Author save(Author author){
        return authorService.save(author);
    }

    public boolean delete(String name){
        return authorService.delete(name);
    }

}
