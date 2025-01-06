package com.api.api_biblioteca.controller;

import com.api.api_biblioteca.domain.Author;
import com.api.api_biblioteca.domain.service.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/all")
    @Operation(summary = "Get all authors")
    @ApiResponse(responseCode = "200", description = "List of all authors")
    public ResponseEntity<List<Author>> getAll() {
        return new ResponseEntity<>(authorService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/contains/{name}")
    @Operation(summary = "Find authors by partial name match")
    @ApiResponse(responseCode = "200", description = "List of authors whose names contain the specified string")
    public ResponseEntity<List<Author>> findByNameContaining(
            @Parameter(description = "Partial name to search for", required = true, example = "John")
            @PathVariable("name") String name) {
        return new ResponseEntity<>(authorService.findByNameContaining(name), HttpStatus.OK);
    }

    @GetMapping("/exact/{name}")
    @Operation(summary = "Find an author by exact name")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Author found"),
            @ApiResponse(responseCode = "404", description = "Author not found")
    })
    public ResponseEntity<Author> findByName(
            @Parameter(description = "Exact name of the author", required = true, example = "John Doe")
            @PathVariable("name") String name) {
        return authorService.findByName(name)
                .map(author -> new ResponseEntity<>(author, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{nationality}")
    @Operation(summary = "Find authors by nationality")
    @ApiResponse(responseCode = "200", description = "List of authors with the specified nationality")
    public ResponseEntity<List<Author>> findByNationality(
            @Parameter(description = "Nationality of the authors to find", required = true, example = "American")
            @PathVariable("nationality") String nationality) {
        return new ResponseEntity<>(authorService.findByNationality(nationality), HttpStatus.OK);
    }

    @GetMapping("/allNameAsc")
    @Operation(summary = "Get all authors ordered by name ascending")
    @ApiResponse(responseCode = "200", description = "List of authors ordered by name in ascending order")
    public ResponseEntity<List<Author>> findAllByOrderByNameAsc() {
        return new ResponseEntity<>(authorService.findAllByOrderByNameAsc(), HttpStatus.OK);
    }

    @GetMapping("/allNameDesc")
    @Operation(summary = "Get all authors ordered by name descending")
    @ApiResponse(responseCode = "200", description = "List of authors ordered by name in descending order")
    public ResponseEntity<List<Author>> findAllByOrderByNameDesc() {
        return new ResponseEntity<>(authorService.findAllByOrderByNameDesc(), HttpStatus.OK);
    }

    @GetMapping("/count/{nationality}")
    @Operation(summary = "Count authors by nationality")
    @ApiResponse(responseCode = "200", description = "The count of authors with the specified nationality")
    public ResponseEntity<Long> countByNationality(
            @Parameter(description = "Nationality of the authors to count", required = true, example = "American")
            @PathVariable("nationality") String nationality) {
        long count = authorService.countByNationality(nationality);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @PostMapping("/save")
    @Operation(summary = "Save a new author")
    @ApiResponse(responseCode = "201", description = "Author successfully created")
    public ResponseEntity<Author> save(
            @Parameter(description = "The author object to save")
            @RequestBody Author author) {
        return new ResponseEntity<>(authorService.save(author), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{name}")
    @Operation(summary = "Delete an author by name")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Author successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Author not found")
    })
    public ResponseEntity<Void> delete(
            @Parameter(description = "The name of the author to delete", required = true, example = "John Doe")
            @PathVariable("name") String name) {
        if (authorService.delete(name)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
