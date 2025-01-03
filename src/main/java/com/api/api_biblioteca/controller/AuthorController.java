package com.api.api_biblioteca.controller;

import com.api.api_biblioteca.domain.Author;
import com.api.api_biblioteca.domain.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;


    @GetMapping("/all")
    public ResponseEntity<List<Author>> getAll() {
        return new ResponseEntity<>(authorService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/contains/{name}")
    public ResponseEntity<List<Author>>findByNameContaining(@PathVariable("name") String name){
            return new ResponseEntity<>(authorService.findByNameContaining(name),HttpStatus.OK);
    }

    @GetMapping("/exact/{name}")
    public ResponseEntity<Author> findByName(@PathVariable("name") String name){
        return authorService.findByName(name)
                .map(author -> new ResponseEntity<>(author,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{nationality}")
    public ResponseEntity<List<Author>> findByNationality(@PathVariable("nationality") String nationality){
        return new ResponseEntity<>(authorService.findByNationality(nationality),HttpStatus.OK);
    }

    @GetMapping("/allNameAsc")
    public ResponseEntity<List<Author>> findAllByOrderByNameAsc(){
        return new ResponseEntity<>(authorService.findAllByOrderByNameAsc(),HttpStatus.OK);
    }

    @GetMapping("/allNameDesc")
    public ResponseEntity<List<Author>> findAllByOrderByNameDesc(){
        return new ResponseEntity<>(authorService.findAllByOrderByNameDesc(),HttpStatus.OK);
    }

    @GetMapping("/count/{nationality}")
    public ResponseEntity<Long> countByNationality(@PathVariable("nationality") String nationality) {
        long count = authorService.countByNationality(nationality);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }


    @PostMapping("/save")
    public ResponseEntity<Author> save(@RequestBody Author author){
        return new ResponseEntity<>(authorService.save(author),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity delete(@PathVariable("name") String name){
        if(authorService.delete(name)){
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
