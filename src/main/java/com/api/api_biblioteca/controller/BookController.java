package com.api.api_biblioteca.controller;

import com.api.api_biblioteca.domain.Book;
import com.api.api_biblioteca.domain.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Optional;


@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/contains/{title}")
    public ResponseEntity<List<Book>> findByTitleContaining(@PathVariable("title") String title) {
        return new ResponseEntity<>(bookService.findByTitleContaining(title), HttpStatus.OK);
    }

    @GetMapping("/exact/{title}")
    public ResponseEntity<Book> findByTitle(@PathVariable("title") String title) {
        return bookService.findByTitle(title)
                .map(book -> new ResponseEntity<>(book, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/author/{authorId}")
    public ResponseEntity<List<Book>> findByAuthorId(@PathVariable("authorId") int authorId) {
        return new ResponseEntity<>(bookService.findByAuthorId(authorId), HttpStatus.OK);
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Book>> findByGenre(@PathVariable("genre") String genre) {
        return new ResponseEntity<>(bookService.findByGenre(genre), HttpStatus.OK);
    }

    @GetMapping("/available")
    public ResponseEntity<List<Book>> findByAvailableTrue() {
        return new ResponseEntity<>(bookService.findByAvailableTrue(), HttpStatus.OK);
    }

    @GetMapping("/published/after/{date}")
    public ResponseEntity<List<Book>> findByPublicationDateAfter(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
        return new ResponseEntity<>(bookService.findByPublicationDateAfter(date), HttpStatus.OK);
    }

    @GetMapping("/published/before/{date}")
    public ResponseEntity<List<Book>> findByPublicationDateBefore(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
        return new ResponseEntity<>(bookService.findByPublicationDateBefore(date), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Book> save(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.save(book), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{title}")
    public ResponseEntity delete(@PathVariable("title") String title) {
        if (bookService.delete(title)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

